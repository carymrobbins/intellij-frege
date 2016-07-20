package com.haskforce.frege.actions;

import com.haskforce.frege.lang.FregeIcons;
import com.haskforce.frege.lang.psi.FregeFile;
import com.haskforce.frege.utils.ClassUtils;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.actions.CreateTemplateInPackageAction;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.ide.fileTemplates.FileTemplateUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.InputValidatorEx;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Properties;

public class CreateFregeFileAction extends CreateTemplateInPackageAction<FregeFile> {

  protected CreateFregeFileAction() {
    super("Frege file", "Create new Frege file", FregeIcons.FILE, null);
  }

  @Nullable
  @Override
  protected PsiElement getNavigationElement(@NotNull FregeFile createdElement) {
    return null;
  }

  @Override
  protected boolean checkPackageExists(PsiDirectory directory) {
    // Adapted from JavaCreateTemplateInPackageAction
    PsiPackage pkg = JavaDirectoryService.getInstance().getPackage(directory);
    if (pkg == null) return false;
    String name = pkg.getQualifiedName();
    return StringUtil.isEmpty(name)
      || PsiNameHelper.getInstance(directory.getProject()).isQualifiedName(name);
  }

  @Nullable
  @Override
  protected FregeFile doCreate(PsiDirectory dir, String className, String templateName) throws IncorrectOperationException {
    Project project = dir.getProject();
    FileTemplateManager templateManager = FileTemplateManager.getInstance(project);
    FileTemplate template = templateManager.getInternalTemplate(templateName);
    PsiPackage pkg = JavaDirectoryService.getInstance().getPackage(dir);
    String pkgName = pkg == null ? null : pkg.getQualifiedName();
    Properties props = new Properties();
    props.setProperty(
      FileTemplate.ATTRIBUTE_NAME,
      pkgName == null || pkgName.isEmpty() ? className : pkg.getQualifiedName() + '.' + className
    );
    try {
      PsiElement el = FileTemplateUtil.createFromTemplate(template, className + ".fr", props, dir);
      if (el == null) return null;
      PsiFile file = el.getContainingFile();
      if (file instanceof FregeFile) return (FregeFile) file;
      throw new AssertionError("Expected FregeFile, got: " + file);
    } catch (IncorrectOperationException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
    builder
      .setTitle("Create new Frege file")
      .addKind("Frege Module", FregeIcons.FILE, "FregeModule")
      .setValidator(new InputValidatorEx() {
        @Nullable
        @Override
        public String getErrorText(String inputString) {
          if (!startsWithUpper(ClassUtils.getClassName(inputString))
                || !PsiNameHelper.getInstance(project).isQualifiedName(inputString)) {
            return "This is not a valid Frege qualified module name";
          }
          return null;
        }

        @Override
        public boolean checkInput(String inputString) {
          return true;
        }

        @Override
        public boolean canClose(String inputString) {
          return !StringUtil.isEmptyOrSpaces(inputString) && getErrorText(inputString) == null;
        }
      });
  }

  @Override
  protected String getActionName(PsiDirectory directory, String newName, String templateName) {
    return "Create Frege file";
  }

  @Override
  protected String removeExtension(String templateName, String className) {
    return StringUtil.trimEnd(className, ".fr");
  }

  private boolean startsWithUpper(String s) {
    if (s == null) return false;
    if (s.length() == 0) return false;
    String c = s.substring(0, 1);
    return c.equals(c.toUpperCase());
  }
}

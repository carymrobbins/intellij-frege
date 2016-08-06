package com.haskforce;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public abstract class ResolveReferenceTestBase extends LightPlatformCodeInsightFixtureTestCase {
  final private String srcPath;
  private PsiReference referenceElement;
  private PsiElement resolvedElement;

  public ResolveReferenceTestBase(String srcPath) {
    this.srcPath = FileUtil.join("testData", srcPath);
  }

  protected void doTest() {
    doTest(true);
  }

  private void doTest(boolean succeed) {
    if (succeed && referenceElement == null) fail("Could not find reference at caret.");
    if (succeed && resolvedElement == null) fail("Could not find resolved element.");
    PsiElement resolvedActual = referenceElement.resolve();
    if (succeed) {
      assertNotNull(
        "Reference not resolved: " + showElementInfo(referenceElement.getElement()),
        resolvedActual
      );
      assertTrue(
        "Could not resolve expected reference.\n" +
          "Expected: " + showElementInfo(resolvedElement) + "\n" +
          "Actual: " + showElementInfo(resolvedActual),
        hasSameTextRange(resolvedElement, resolvedActual)
      );
    } else {
      assertNull(
        "Resolved unexpected reference: " + showElementInfo(resolvedElement),
        resolvedElement
      );
    }
  }

  private boolean hasSameTextRange(@NotNull PsiElement e1, @NotNull PsiElement e2) {
    return e1.getContainingFile().equals(e2.getContainingFile())
      && e1.getTextRange().equals(e2.getTextRange())
      && e1.getText().equals(e2.getText());
  }

  private String showElementInfo(@NotNull PsiElement el) {
    return el + " at " + el.getTextRange() + " with text '" + el.getText() + "'";
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    getTestDataFiles().forEach(file -> {
      try {
        String text = loadFile(file);
        int referenceOffset = text.indexOf("<ref>");
        text = text.replace("<ref>", "");
        int resolvedOffset = text.indexOf("<resolved>");
        text = text.replace("<resolved>", "");
        String relativePath = getTestDataFileRelativePath(file);
        VirtualFile vFile = myFixture.getTempDirFixture().createFile(relativePath, text);
        PsiFile psiFile = myFixture.configureFromTempProjectFile(relativePath);
        if (referenceOffset != -1) {
          referenceElement = psiFile.findReferenceAt(referenceOffset);
          if (referenceElement == null) fail("Reference element was null in " + file.getName());
        }
        if (resolvedOffset != -1) {
          resolvedElement = psiFile.findElementAt(resolvedOffset);
          if (resolvedElement == null) fail("Resolved element was null in " + file.getName());
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }

  /** Gets path of test data file relative to the test name directory. */
  @NotNull
  private String getTestDataFileRelativePath(File file) throws IOException {
    return file.getCanonicalPath().substring(
      file.getCanonicalPath().indexOf(getTestDataPath()) + getTestDataPath().length() + 1
    );
  }

  @Override
  protected String getTestDataPath() {
    return FileUtil.join(srcPath, getTestName(false));
  }

  private Stream<File> getTestDataFiles() {
    try {
      return Files.walk(Paths.get(getTestDataPath())).map(Path::toFile).filter(File::isFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @NotNull
  private static String loadFile(File file) {
    try {
      return StringUtil.convertLineSeparators(FileUtil.loadFile(file, CharsetToolkit.UTF8));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

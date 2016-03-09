package com.haskforce.frege.lang.psi;

import com.haskforce.frege.lang.FregeFileType;
import com.haskforce.frege.lang.FregeIcons;
import com.haskforce.frege.lang.FregeLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/** Root Psi element for Frege files. */
public class FregeFile extends PsiFileBase {
  public FregeFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, FregeLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return FregeFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Frege file";
  }

  @Nullable
  @Override
  public Icon getIcon(int flags) {
    return FregeIcons.FILE;
  }
}

package com.haskforce.frege.lang.psi.impl;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public abstract class FregePsiUtil {

  public static Optional<FregeModulePackage> getModulePackage(@NotNull FregeModuleName moduleName) {
    return Optional.ofNullable(PsiTreeUtil.getPrevSiblingOfType(moduleName, FregeModulePackage.class));
  }
}

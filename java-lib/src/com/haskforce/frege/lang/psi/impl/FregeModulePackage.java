package com.haskforce.frege.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiPackage;
import org.jetbrains.annotations.NotNull;

public class FregeModulePackage extends FregeCompositeElementImpl {
  public FregeModulePackage(@NotNull ASTNode node) {
    super(node);
  }
}

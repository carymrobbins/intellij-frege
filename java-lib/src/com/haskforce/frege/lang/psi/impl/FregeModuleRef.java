package com.haskforce.frege.lang.psi.impl;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FregeModuleRef extends FregeCompositeElementImpl {
  public FregeModuleRef(@NotNull ASTNode node) {
    super(node);
  }

  @Nullable
  public FregeModulePackage getModulePackage() {
    return findChildByClass(FregeModulePackage.class);
  }

  @Nullable
  public FregeModuleName getModuleName() {
    return findChildByClass(FregeModuleName.class);
  }
}

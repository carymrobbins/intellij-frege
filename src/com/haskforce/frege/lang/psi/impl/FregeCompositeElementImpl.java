package com.haskforce.frege.lang.psi.impl;

import com.haskforce.frege.lang.psi.FregeCompositeElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class FregeCompositeElementImpl
  extends ASTWrapperPsiElement
  implements FregeCompositeElement {

  public FregeCompositeElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String toString() {
    return getNode().getElementType().toString();
  }
}

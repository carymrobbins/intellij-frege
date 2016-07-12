package com.haskforce.frege.lang.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public abstract class FregeElementFactory {
  public static PsiElement createElement(ASTNode node) {
    IElementType t = node.getElementType();
    if (t == FregeTokenTypes.MODULE_DECL) return new FregeModuleDecl(node);
    if (t == FregeTokenTypes.MODULE_NAME) return new FregeModuleName(node);
    throw new AssertionError("Unsupported Frege element type: " + t);
  }
}

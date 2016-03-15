package com.haskforce.frege.lang.psi.impl;

import com.intellij.lang.ASTNode;
import frege.compiler.types.ImportDetails;
import org.jetbrains.annotations.NotNull;

public class FregeImportItemImpl extends FregeCompositeElementImpl {

  public FregeImportItemImpl(@NotNull ASTNode node) {
    super(node);
  }
}

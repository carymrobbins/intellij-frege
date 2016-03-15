package com.haskforce.frege.lang.psi.impl;

import com.intellij.lang.ASTNode;
import frege.compiler.types.SourceDefinitions;
import org.jetbrains.annotations.NotNull;

public class FregeLetImpl extends FregeCompositeElementImpl {
  public FregeLetImpl(@NotNull ASTNode node) {
    super(node);
  }
}

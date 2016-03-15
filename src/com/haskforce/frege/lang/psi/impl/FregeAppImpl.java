package com.haskforce.frege.lang.psi.impl;

import com.intellij.lang.ASTNode;
import frege.compiler.types.SourceDefinitions;
import org.jetbrains.annotations.NotNull;

public class FregeAppImpl extends FregeCompositeElementImpl {

  public FregeAppImpl(@NotNull ASTNode node) {
    super(node);
  }
}

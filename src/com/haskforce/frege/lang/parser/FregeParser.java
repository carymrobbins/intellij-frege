package com.haskforce.frege.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/** A dummy parser which doesn't actually do anything. */
public class FregeParser implements PsiParser {
  @NotNull
  @Override
  public ASTNode parse(@NotNull IElementType root, @NotNull PsiBuilder builder) {
    PsiBuilder.Marker marker = builder.mark();
    while (!builder.eof()) {
      builder.advanceLexer();
    }
    marker.done(root);
    return builder.getTreeBuilt();
  }
}

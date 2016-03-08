package com.haskforce.frege.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import frege.prelude.PreludeBase;
import frege.run8.Thunk;
import org.jetbrains.annotations.NotNull;

public class FregePsiParser implements PsiParser {
  @NotNull
  @Override
  public ASTNode parse(@NotNull IElementType root, @NotNull PsiBuilder builder) {
    return PreludeBase.TST.<ASTNode>performUnsafe(
      FregeParser.psiParse(Thunk.<IElementType>lazy(root), builder)
    ).call();
  }
}

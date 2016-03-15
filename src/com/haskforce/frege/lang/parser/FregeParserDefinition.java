package com.haskforce.frege.lang.parser;

import com.haskforce.frege.lang.FregeLanguage;
import com.haskforce.frege.lang.lexer.FregeParsingLexer;
import com.haskforce.frege.lang.lexer.FregeTokenTypes;
import com.haskforce.frege.lang.psi.FregeFile;
import com.haskforce.frege.lang.psi.FregePsiTypes;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

/** Registers a parser and parsing lexer for Frege files. */
public class FregeParserDefinition implements ParserDefinition {
  private static final IFileElementType FILE = new IFileElementType(FregeLanguage.INSTANCE);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
      return new FregeParsingLexer();
  }

  @Override
  public PsiParser createParser(Project project) {
    return new FregeParser();
  }

  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @NotNull
  @Override
  public TokenSet getWhitespaceTokens() {
    return TokenSet.EMPTY;
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return TokenSet.create(
      FregeTokenTypes.COMMENT
    );
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return TokenSet.create(
      FregeTokenTypes.STRCONST
    );
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return FregePsiTypes.createElement(node);
  }

  @Override
  public PsiFile createFile(FileViewProvider viewProvider) {
    return new FregeFile(viewProvider);
  }

  @Override
  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return SpaceRequirements.MAY;
  }
}

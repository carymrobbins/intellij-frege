package com.haskforce.frege.lang.parser;

import com.haskforce.frege.lang.FregeLanguage;
import com.haskforce.frege.lang.lexer.FregeParsingLexer;
import com.haskforce.frege.lang.psi.FregeElementFactory;
import com.haskforce.frege.lang.psi.FregeFile;
import com.haskforce.frege.lang.psi.FregeTokenTypes;
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

  // NOTE: You must use CabalLanguage.INSTANCE instead of Language.findInstance()
  // since the language may not have been initialized yet.
  private static final IFileElementType FILE = new IFileElementType(FregeLanguage.INSTANCE);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new FregeParsingLexer();
  }

  @Override
  public PsiParser createParser(Project project) {
    return new FregePsiParser();
  }

  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @NotNull
  @Override
  public TokenSet getWhitespaceTokens() {
    return whitespaceTokens;
  }

  private static TokenSet whitespaceTokens = TokenSet.create(
    FregeTokenTypes.WHITE_SPACE
  );

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return commentTokens;
  }

  private static TokenSet commentTokens = TokenSet.create(
    FregeTokenTypes.BLOCK_COMMENT,
    FregeTokenTypes.LINE_COMMENT,
    FregeTokenTypes.DOC_COMMENT
  );

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return stringLiterals;
  }

  private static TokenSet stringLiterals = TokenSet.create(
    FregeTokenTypes.STRING_LITERAL
  );

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return FregeElementFactory.createElement(node);
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

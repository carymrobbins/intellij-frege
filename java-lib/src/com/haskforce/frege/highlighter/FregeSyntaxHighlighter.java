package com.haskforce.frege.highlighter;

import com.haskforce.frege.lang.lexer.FregeSyntaxHighlighterTypes;
import com.haskforce.frege.lang.lexer.FregeSyntaxHighlightingLexer;
import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/** Maps tokens to colors for syntax highlighting. */
public class FregeSyntaxHighlighter extends SyntaxHighlighterBase {
  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new FregeSyntaxHighlightingLexer();
  }

  @NotNull
  @Override
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
    return pack(keys.get(tokenType), EMPTY);
  }

  // TODO: Create text attributes specifically for Frege
  // https://confluence.jetbrains.com/pages/viewpage.action?pageId=49463468
  private static final TextAttributesKey JAVA_KEYWORD = TextAttributesKey.createTextAttributesKey(
    "JAVA_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD
  );

  private static final Map<IElementType, TextAttributesKey> keys;

  static {
    keys = new HashMap<>(20);
    keys.put(FregeSyntaxHighlighterTypes.DOC_COMMENT, DefaultLanguageHighlighterColors.DOC_COMMENT);
    keys.put(FregeSyntaxHighlighterTypes.LINE_COMMENT, DefaultLanguageHighlighterColors.LINE_COMMENT);
    keys.put(FregeSyntaxHighlighterTypes.BLOCK_COMMENT, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    keys.put(FregeSyntaxHighlighterTypes.STRING_LITERAL, DefaultLanguageHighlighterColors.STRING);
    keys.put(FregeSyntaxHighlighterTypes.CHAR_LITERAL, DefaultLanguageHighlighterColors.NUMBER);
    keys.put(FregeSyntaxHighlighterTypes.NUMBER_LITERAL, DefaultLanguageHighlighterColors.NUMBER);
    keys.put(FregeSyntaxHighlighterTypes.KEYWORD, JAVA_KEYWORD);
    keys.put(FregeSyntaxHighlighterTypes.IDENT, DefaultLanguageHighlighterColors.IDENTIFIER);
    keys.put(FregeSyntaxHighlighterTypes.INFIX_IDENT, DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    keys.put(FregeSyntaxHighlighterTypes.OPERATOR, JavaHighlightingColors.TYPE_PARAMETER_NAME_ATTRIBUTES);
    keys.put(FregeSyntaxHighlighterTypes.LPAREN, DefaultLanguageHighlighterColors.PARENTHESES);
    keys.put(FregeSyntaxHighlighterTypes.RPAREN, DefaultLanguageHighlighterColors.PARENTHESES);
    keys.put(FregeSyntaxHighlighterTypes.LBRACE, DefaultLanguageHighlighterColors.BRACES);
    keys.put(FregeSyntaxHighlighterTypes.RBRACE, DefaultLanguageHighlighterColors.BRACES);
    keys.put(FregeSyntaxHighlighterTypes.LBRACKET, DefaultLanguageHighlighterColors.BRACKETS);
    keys.put(FregeSyntaxHighlighterTypes.RBRACKET, DefaultLanguageHighlighterColors.BRACKETS);
    keys.put(FregeSyntaxHighlighterTypes.COMMA, DefaultLanguageHighlighterColors.COMMA);
    keys.put(FregeSyntaxHighlighterTypes.DOT, DefaultLanguageHighlighterColors.DOT);
    keys.put(com.intellij.psi.TokenType.BAD_CHARACTER, HighlighterColors.BAD_CHARACTER);
  }
}

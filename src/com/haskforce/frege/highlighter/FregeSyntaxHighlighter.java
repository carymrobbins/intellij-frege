package com.haskforce.frege.highlighter;

import com.haskforce.frege.lang.lexer.FregeSyntaxHighlightingLexer;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.haskforce.frege.lang.lexer.FregeSyntaxHighlighterTypes.*;

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
    keys.put(DOC_COMMENT, DefaultLanguageHighlighterColors.DOC_COMMENT);
    keys.put(LINE_COMMENT, DefaultLanguageHighlighterColors.LINE_COMMENT);
    keys.put(BLOCK_COMMENT, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    keys.put(STRING_LITERAL, DefaultLanguageHighlighterColors.STRING);
    keys.put(CHAR_LITERAL, DefaultLanguageHighlighterColors.NUMBER);
    keys.put(NUMBER_LITERAL, DefaultLanguageHighlighterColors.NUMBER);
    keys.put(KEYWORD, JAVA_KEYWORD);
    keys.put(IDENT, DefaultLanguageHighlighterColors.IDENTIFIER);
    keys.put(INFIX_IDENT, DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    keys.put(OPERATOR, CodeInsightColors.TYPE_PARAMETER_NAME_ATTRIBUTES);
    keys.put(LPAREN, DefaultLanguageHighlighterColors.PARENTHESES);
    keys.put(RPAREN, DefaultLanguageHighlighterColors.PARENTHESES);
    keys.put(LBRACE, DefaultLanguageHighlighterColors.BRACES);
    keys.put(RBRACE, DefaultLanguageHighlighterColors.BRACES);
    keys.put(LBRACKET, DefaultLanguageHighlighterColors.BRACKETS);
    keys.put(RBRACKET, DefaultLanguageHighlighterColors.BRACKETS);
    keys.put(COMMA, DefaultLanguageHighlighterColors.COMMA);
    keys.put(DOT, DefaultLanguageHighlighterColors.DOT);
    keys.put(com.intellij.psi.TokenType.BAD_CHARACTER, HighlighterColors.BAD_CHARACTER);
  }
}

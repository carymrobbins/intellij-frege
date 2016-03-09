package com.haskforce.frege.lang.lexer;

/** Token types for the syntax highlighter. */
public abstract class FregeSyntaxHighlighterTypes {
  public static FregeTokenType DOC_COMMENT = new FregeTokenType("DOC_COMMENT");
  public static FregeTokenType LINE_COMMENT = new FregeTokenType("LINE_COMMENT");
  public static FregeTokenType BLOCK_COMMENT = new FregeTokenType("BLOCK_COMMENT");
  public static FregeTokenType STRING_LITERAL = new FregeTokenType("STRING_LITERAL");
  public static FregeTokenType CHAR_LITERAL = new FregeTokenType("CHAR_LITERAL");
  public static FregeTokenType NUMBER_LITERAL = new FregeTokenType("NUMBER_LITERAL");
  public static FregeTokenType KEYWORD = new FregeTokenType("KEYWORD");
  public static FregeTokenType IDENT = new FregeTokenType("IDENT");
  public static FregeTokenType INFIX_IDENT = new FregeTokenType("INFIX_IDENT");
  public static FregeTokenType OPERATOR = new FregeTokenType("OPERATOR");
  public static FregeTokenType LPAREN = new FregeTokenType("LPAREN");
  public static FregeTokenType RPAREN = new FregeTokenType("RPAREN");
  public static FregeTokenType LBRACE = new FregeTokenType("LBRACE");
  public static FregeTokenType RBRACE = new FregeTokenType("RBRACE");
  public static FregeTokenType LBRACKET = new FregeTokenType("LBRACKET");
  public static FregeTokenType RBRACKET = new FregeTokenType("RBRACKET");
  public static FregeTokenType COMMA = new FregeTokenType("COMMA");
  public static FregeTokenType DOT = new FregeTokenType("DOT");
}

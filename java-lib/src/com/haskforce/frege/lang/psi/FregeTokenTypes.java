package com.haskforce.frege.lang.psi;

import com.intellij.psi.tree.IElementType;

/** Token types used by the parsing lexer, NOT for syntax highlighting. */
public abstract class FregeTokenTypes {

  // Re-exported tokens
  public static IElementType WHITE_SPACE = com.intellij.psi.TokenType.WHITE_SPACE;
  public static IElementType BAD_CHAR = com.intellij.psi.TokenType.BAD_CHARACTER;

  // COMMENTS
  public static FregeTokenType LINE_COMMENT = new FregeTokenType("LINE_COMMENT");
  public static FregeTokenType DOC_COMMENT = new FregeTokenType("DOC_COMMENT");
  public static FregeTokenType BLOCK_COMMENT = new FregeTokenType("BLOCK_COMMENT");

  // KEYWORDS
  public static FregeTokenType PACKAGE = new FregeTokenType("PACKAGE");
  public static FregeTokenType MODULE = new FregeTokenType("MODULE");
  public static FregeTokenType IMPORT = new FregeTokenType("IMPORT");
  public static FregeTokenType NATIVE = new FregeTokenType("NATIVE");
  public static FregeTokenType IF = new FregeTokenType("IF");
  public static FregeTokenType THEN = new FregeTokenType("THEN");
  public static FregeTokenType ELSE = new FregeTokenType("ELSE");
  public static FregeTokenType CLASS = new FregeTokenType("CLASS");
  public static FregeTokenType WHERE = new FregeTokenType("WHERE");
  public static FregeTokenType INSTANCE = new FregeTokenType("INSTANCE");
  public static FregeTokenType DATA = new FregeTokenType("DATA");
  public static FregeTokenType CASE = new FregeTokenType("CASE");
  public static FregeTokenType OF = new FregeTokenType("OF");
  public static FregeTokenType DERIVE = new FregeTokenType("DERIVE");
  public static FregeTokenType LET = new FregeTokenType("LET");
  public static FregeTokenType IN = new FregeTokenType("IN");
  public static FregeTokenType TYPE = new FregeTokenType("TYPE");
  public static FregeTokenType TRUE = new FregeTokenType("TRUE");
  public static FregeTokenType FALSE = new FregeTokenType("FALSE");
  public static FregeTokenType PURE = new FregeTokenType("PURE");
  public static FregeTokenType PRIVATE = new FregeTokenType("PRIVATE");
  public static FregeTokenType PUBLIC = new FregeTokenType("PUBLIC");
  public static FregeTokenType PROTECTED = new FregeTokenType("PROTECTED");
  public static FregeTokenType ABSTRACT = new FregeTokenType("ABSTRACT");
  public static FregeTokenType DO = new FregeTokenType("DO");
  public static FregeTokenType FORALL = new FregeTokenType("FORALL");
  public static FregeTokenType THROWS = new FregeTokenType("THROWS");
  public static FregeTokenType MUTABLE = new FregeTokenType("MUTABLE");
  public static FregeTokenType INFIX = new FregeTokenType("INFIX");
  public static FregeTokenType INFIXL = new FregeTokenType("INFIXL");
  public static FregeTokenType INFIXR = new FregeTokenType("INFIXR");

  // LAYOUT
  public static FregeTokenType LBRACKET = new FregeTokenType("[");
  public static FregeTokenType RBRACKET = new FregeTokenType("]");
  public static FregeTokenType LBRACE = new FregeTokenType("{");
  public static FregeTokenType RBRACE = new FregeTokenType("}");
  public static FregeTokenType LPAREN = new FregeTokenType("(");
  public static FregeTokenType RPAREN = new FregeTokenType(")");
  public static FregeTokenType SEMICOLON = new FregeTokenType(";");
  public static FregeTokenType COMMA = new FregeTokenType(",");

  // IDENTIFIERS
  public static FregeTokenType UNDERSCORE = new FregeTokenType("_");
  public static FregeTokenType IDENT = new FregeTokenType("IDENT");

  // SYMBOLS
  public static FregeTokenType DOT = new FregeTokenType(".");
  public static FregeTokenType BACKTICK = new FregeTokenType("`");
  public static FregeTokenType EQUALS = new FregeTokenType("=");
  public static FregeTokenType OPERATOR = new FregeTokenType("OPERATOR");

  // LITERALS
  public static FregeTokenType STRING_LITERAL = new FregeTokenType("STRING_LITERAL");
  public static FregeTokenType CHAR_LITERAL = new FregeTokenType("CHAR_LITERAL");
  public static FregeTokenType NUMBER_LITERAL = new FregeTokenType("NUMBER_LITERAL");

  // OTHER
  public static FregeTokenType EOL = new FregeTokenType("EOL");
  public static FregeTokenType INDENT = new FregeTokenType("INDENT");
  public static FregeTokenType DEDENT = new FregeTokenType("DEDENT");

  // PARSER ELEMENTS
  public static FregeElementType MODULE_DECL = new FregeElementType("MODULE_DECL");
  public static FregeElementType MODULE_PACKAGE = new FregeElementType("MODULE_PACKAGE");
  public static FregeElementType MODULE_NAME = new FregeElementType("MODULE_NAME");
}

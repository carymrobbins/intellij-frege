package com.haskforce.frege.lang.psi;

import com.haskforce.frege.lang.psi.stubs.FregeModuleNameStubElementType;
import com.intellij.psi.tree.IElementType;

/** Token types used by the parsing lexer, NOT for syntax highlighting. */
public abstract class FregeTokenTypes {

  // Re-exported tokens
  public static IElementType WHITE_SPACE = com.intellij.psi.TokenType.WHITE_SPACE;
  public static IElementType BAD_CHAR = com.intellij.psi.TokenType.BAD_CHARACTER;

  // COMMENTS
  public static IElementType LINE_COMMENT = new FregeTokenType("LINE_COMMENT");
  public static IElementType DOC_COMMENT = new FregeTokenType("DOC_COMMENT");
  public static IElementType BLOCK_COMMENT = new FregeTokenType("BLOCK_COMMENT");

  // KEYWORDS
  public static IElementType PACKAGE = new FregeTokenType("PACKAGE");
  public static IElementType MODULE = new FregeTokenType("MODULE");
  public static IElementType IMPORT = new FregeTokenType("IMPORT");
  public static IElementType NATIVE = new FregeTokenType("NATIVE");
  public static IElementType IF = new FregeTokenType("IF");
  public static IElementType THEN = new FregeTokenType("THEN");
  public static IElementType ELSE = new FregeTokenType("ELSE");
  public static IElementType CLASS = new FregeTokenType("CLASS");
  public static IElementType WHERE = new FregeTokenType("WHERE");
  public static IElementType INSTANCE = new FregeTokenType("INSTANCE");
  public static IElementType DATA = new FregeTokenType("DATA");
  public static IElementType CASE = new FregeTokenType("CASE");
  public static IElementType OF = new FregeTokenType("OF");
  public static IElementType DERIVE = new FregeTokenType("DERIVE");
  public static IElementType LET = new FregeTokenType("LET");
  public static IElementType IN = new FregeTokenType("IN");
  public static IElementType TYPE = new FregeTokenType("TYPE");
  public static IElementType TRUE = new FregeTokenType("TRUE");
  public static IElementType FALSE = new FregeTokenType("FALSE");
  public static IElementType PURE = new FregeTokenType("PURE");
  public static IElementType PRIVATE = new FregeTokenType("PRIVATE");
  public static IElementType PUBLIC = new FregeTokenType("PUBLIC");
  public static IElementType PROTECTED = new FregeTokenType("PROTECTED");
  public static IElementType ABSTRACT = new FregeTokenType("ABSTRACT");
  public static IElementType DO = new FregeTokenType("DO");
  public static IElementType FORALL = new FregeTokenType("FORALL");
  public static IElementType THROWS = new FregeTokenType("THROWS");
  public static IElementType MUTABLE = new FregeTokenType("MUTABLE");
  public static IElementType INFIX = new FregeTokenType("INFIX");
  public static IElementType INFIXL = new FregeTokenType("INFIXL");
  public static IElementType INFIXR = new FregeTokenType("INFIXR");

  // LAYOUT
  public static IElementType LBRACKET = new FregeTokenType("[");
  public static IElementType RBRACKET = new FregeTokenType("]");
  public static IElementType LBRACE = new FregeTokenType("{");
  public static IElementType RBRACE = new FregeTokenType("}");
  public static IElementType LPAREN = new FregeTokenType("(");
  public static IElementType RPAREN = new FregeTokenType(")");
  public static IElementType SEMICOLON = new FregeTokenType(";");
  public static IElementType COMMA = new FregeTokenType(",");

  // IDENTIFIERS
  public static IElementType UNDERSCORE = new FregeTokenType("_");
  public static IElementType IDENT = new FregeTokenType("IDENT");

  // SYMBOLS
  public static IElementType DOT = new FregeTokenType(".");
  public static IElementType BACKTICK = new FregeTokenType("`");
  public static IElementType EQUALS = new FregeTokenType("=");
  public static IElementType OPERATOR = new FregeTokenType("OPERATOR");

  // LITERALS
  public static IElementType STRING_LITERAL = new FregeTokenType("STRING_LITERAL");
  public static IElementType CHAR_LITERAL = new FregeTokenType("CHAR_LITERAL");
  public static IElementType NUMBER_LITERAL = new FregeTokenType("NUMBER_LITERAL");

  // OTHER
  public static IElementType EOL = new FregeTokenType("EOL");
  public static IElementType INDENT = new FregeTokenType("INDENT");
  public static IElementType DEDENT = new FregeTokenType("DEDENT");

  // PARSER ELEMENTS
  public static IElementType MODULE_DECL = new FregeElementType("MODULE_DECL");
  public static IElementType MODULE_PACKAGE = new FregeElementType("MODULE_PACKAGE");
  public static IElementType MODULE_NAME = new FregeModuleNameStubElementType("MODULE_NAME");
}

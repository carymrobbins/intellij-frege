package com.haskforce.frege.lang.lexer;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.haskforce.frege.lang.lexer.FregeSyntaxHighlighterTypes.*;
%%

%{
  private int yychar;
  public _FregeSyntaxHighlightingLexer() { this((java.io.Reader)null); }
%}

%public
%class _FregeSyntaxHighlightingLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%char
%eof{ return;
%eof}

EOL=\r|\n|\r\n
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

COMMENT=--([^\!\#\$\%\&\*\+\.\/\<\=\>\?\@\\\^\|\~\:\r\n][^\r\n]*\n?|[\r\n])
DOC=---([^\!\#\$\%\&\*\+\.\/\<\=\>\?\@\\\^\|\~\:\r\n][^\r\n]*\n?|[\r\n])
BLOCK_COMMENT=\{-([^-]|-[^}])*-*\}

IDENT=[A-Za-z_][A-Za-z0-9_]*
INFIX_IDENT=`[^`]+`
NUMBER_LIT=\-?[0-9]+(\.[0-9]+)?
// Use ? at end to highlight unterminated strings.
STRING_LIT=\"(\\\"|[^\"])*\"?
CHAR_LIT=('\\''|'[^']')

// HACK: If it's none of these, let's assume it's an operator.
SYMBOL=[^A-Za-z0-9_\(\)\[\]\{\}\r\n\ \t\f\.]+

%%

<YYINITIAL> {
  {WHITE_SPACE}           { return com.intellij.psi.TokenType.WHITE_SPACE; }
  {DOC}                   { return DOC_COMMENT; }
  {COMMENT}               { return LINE_COMMENT; }
  {BLOCK_COMMENT}         { return BLOCK_COMMENT; }
  {STRING_LIT}            { return STRING_LITERAL; }
  {CHAR_LIT}              { return CHAR_LITERAL; }
  {NUMBER_LIT}            { return NUMBER_LITERAL; }

  "package"               { return KEYWORD; }
  "module"                { return KEYWORD; }
  "import"                { return KEYWORD; }
  "native"                { return KEYWORD; }
  "if"                    { return KEYWORD; }
  "then"                  { return KEYWORD; }
  "else"                  { return KEYWORD; }
  "class"                 { return KEYWORD; }
  "where"                 { return KEYWORD; }
  "instance"              { return KEYWORD; }
  "data"                  { return KEYWORD; }
  "case"                  { return KEYWORD; }
  "of"                    { return KEYWORD; }
  "derive"                { return KEYWORD; }
  "let"                   { return KEYWORD; }
  "in"                    { return KEYWORD; }
  "type"                  { return KEYWORD; }
  "true"                  { return KEYWORD; }
  "false"                 { return KEYWORD; }
  "pure"                  { return KEYWORD; }
  "private"               { return KEYWORD; }
  "public"                { return KEYWORD; }
  "protected"             { return KEYWORD; }
  "abstract"              { return KEYWORD; }
  "do"                    { return KEYWORD; }
  "forall"                { return KEYWORD; }
  "throws"                { return KEYWORD; }
  "mutable"               { return KEYWORD; }
  "infix"                 { return KEYWORD; }
  "infixl"                { return KEYWORD; }
  "infixr"                { return KEYWORD; }

  "("                     { return LPAREN; }
  ")"                     { return RPAREN; }
  "{"                     { return LBRACE; }
  "}"                     { return RBRACE; }
  "["                     { return LBRACKET; }
  "]"                     { return RBRACKET; }
  ","                     { return COMMA; }
  "."                     { return DOT; }

  {IDENT}                 { return IDENT; }
  {INFIX_IDENT}           { return INFIX_IDENT; }
  {SYMBOL}                { return OPERATOR; }
}

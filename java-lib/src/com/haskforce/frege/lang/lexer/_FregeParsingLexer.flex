package com.haskforce.frege.lang.lexer;

import java.util.regex.*;

import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;

import com.haskforce.frege.lang.lexer.FregeTokenTypes;

%%

%{
  public _FregeParsingLexer() { this((java.io.Reader)null); }

  private int yychar;

  /** This should match the newline indent rule defined in our Flex lexer. */
  public static Pattern NEWLINE_INDENT_REGEX = Pattern.compile(
    "(\\r|\\n|\\r\\n)(( |\\t)*)", Pattern.MULTILINE
  );

  protected int currentLineIndent = 0;
  protected int indentLevel = 0;
%}

%public
%class _FregeParsingLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%char
%eof{ return;
%eof}

EOL=\r|\n|\r\n
WHITE_SPACE=[\ \t\f]
NOT_WHITE_SPACE=[^\ \t\f]

LINE_COMMENT=--([^\!\#\$\%\&\*\+\.\/\<\=\>\?\@\\\^\|\~\:\r\n][^\r\n]*\n?|[\r\n])
DOC_COMMENT=---([^\!\#\$\%\&\*\+\.\/\<\=\>\?\@\\\^\|\~\:\r\n][^\r\n]*\n?|[\r\n])
BLOCK_COMMENT=\{-([^-]|-[^}])*-*\}

NUMBER_LIT=\-?[0-9]+(\.[0-9]+)?
STRING_LIT=\"(\\\"|[^\"])*\"
CHAR_LIT=('\\''|'[^']')

IDENT=(_|[:letter:])(_|[:letter:]|[:digit:])*

// Based on Frege's Lexer
// https://github.com/Frege/frege/blob/e6166122c115b1cbfce4c832080efe1dfa230b2f/frege/compiler/grammar/Lexer.fr#L169-L190
OPERATOR=[^,;´\"'()\[\]\{\}\r\n\ \t\f:letter::digit:]

%state MAIN, INDENT

%%

<YYINITIAL> {
  // NOTE: This is mostly a hack so we can get out of the YYINITIAL state.
  // The IntelliJ parser assumes that it can start a fresh parse any time we're
  // at YYINITIAL. With whitespace-sensitive syntax this creates some issues,
  // so we want to generally use a non-YYINITIAL state.
  [^] { yypushback(1); yybegin(MAIN); }
}

<MAIN> {
  {DOC_COMMENT}           { return FregeTokenTypes.DOC_COMMENT; }
  {LINE_COMMENT}          { return FregeTokenTypes.LINE_COMMENT; }
  {BLOCK_COMMENT}         { return FregeTokenTypes.BLOCK_COMMENT; }

  {STRING_LIT}            { return FregeTokenTypes.STRING_LITERAL; }
  {CHAR_LIT}              { return FregeTokenTypes.CHAR_LITERAL; }
  {NUMBER_LIT}            { return FregeTokenTypes.NUMBER_LITERAL; }

  // KEYWORDS
  "package"               { return FregeTokenTypes.PACKAGE; }
  "module"                { return FregeTokenTypes.MODULE; }
  "import"                { return FregeTokenTypes.IMPORT; }
  "native"                { return FregeTokenTypes.NATIVE; }
  "if"                    { return FregeTokenTypes.IF; }
  "then"                  { return FregeTokenTypes.THEN; }
  "else"                  { return FregeTokenTypes.ELSE; }
  "class"                 { return FregeTokenTypes.CLASS; }
  "where"                 { return FregeTokenTypes.WHERE; }
  "instance"              { return FregeTokenTypes.INSTANCE; }
  "data"                  { return FregeTokenTypes.DATA; }
  "case"                  { return FregeTokenTypes.CASE; }
  "of"                    { return FregeTokenTypes.OF; }
  "derive"                { return FregeTokenTypes.DERIVE; }
  "let"                   { return FregeTokenTypes.LET; }
  "in"                    { return FregeTokenTypes.IN; }
  "type"                  { return FregeTokenTypes.TYPE; }
  "true"                  { return FregeTokenTypes.TRUE; }
  "false"                 { return FregeTokenTypes.FALSE; }
  "pure"                  { return FregeTokenTypes.PURE; }
  "private"               { return FregeTokenTypes.PRIVATE; }
  "public"                { return FregeTokenTypes.PUBLIC; }
  "protected"             { return FregeTokenTypes.PROTECTED; }
  "abstract"              { return FregeTokenTypes.ABSTRACT; }
  "do"                    { return FregeTokenTypes.DO; }
  "forall"                { return FregeTokenTypes.FORALL; }
  "throws"                { return FregeTokenTypes.THROWS; }
  "mutable"               { return FregeTokenTypes.MUTABLE; }
  "infix"                 { return FregeTokenTypes.INFIX; }
  "infixl"                { return FregeTokenTypes.INFIXL; }
  "infixr"                { return FregeTokenTypes.INFIXR; }

  // SYMBOLIC LAYOUT
  "["                     { return FregeTokenTypes.LBRACKET; }
  "]"                     { return FregeTokenTypes.RBRACKET; }
  "{"                     { return FregeTokenTypes.LBRACE; }
  "}"                     { return FregeTokenTypes.RBRACE; }
  "("                     { return FregeTokenTypes.LPAREN; }
  ")"                     { return FregeTokenTypes.RPAREN; }
  ";"                     { return FregeTokenTypes.SEMICOLON; }
  ","                     { return FregeTokenTypes.COMMA; }

  // IDENTIFIERS
  "_"                     { return FregeTokenTypes.UNDERSCORE; }
  {IDENT}                 { return FregeTokenTypes.IDENT; }

  // SYMBOLS
  "."                     { return FregeTokenTypes.DOT; }
  "`"                     { return FregeTokenTypes.BACKTICK; }
  "="                     { return FregeTokenTypes.EQUALS; }
  {OPERATOR}              { return FregeTokenTypes.OPERATOR; }

  // WHITESPACE LAYOUT

  {WHITE_SPACE}+          { return FregeTokenTypes.WHITE_SPACE; }

  // Newline indent rule, this should match the NEWLINE_INDENT_REGEX pattern.
  {EOL} {WHITE_SPACE}* {
    final Matcher m = NEWLINE_INDENT_REGEX.matcher(yytext());
    if (!m.matches()) throw new AssertionError("NEWLINE_INDENT_REGEX did not match!");
    final String indent = m.group(2);
    yypushback(indent.length());
    yybegin(INDENT);
    return FregeTokenTypes.EOL;
  }

  [^]                     { return FregeTokenTypes.BAD_CHAR; }
}

<INDENT> {
  // Comments shouldn't affect the indentation
  {WHITE_SPACE}* {DOC_COMMENT}           { return FregeTokenTypes.DOC_COMMENT; }
  {WHITE_SPACE}* {LINE_COMMENT}          { return FregeTokenTypes.LINE_COMMENT; }
  {WHITE_SPACE}* {BLOCK_COMMENT}         { return FregeTokenTypes.BLOCK_COMMENT; }

  // A pure whitespace line can be disregarded.
  {WHITE_SPACE}* {EOL} { currentLineIndent = 0; return FregeTokenTypes.WHITE_SPACE; }

  // This rule only consumes zero or one whitespaces and returns an INDENT or DEDENT token.
  // The rule will be continually applied until there are zero whitespaces.
  {WHITE_SPACE}* {NOT_WHITE_SPACE} {
    final int numWhitespace = yylength() - 1;

    if (currentLineIndent == 0) {
      if (numWhitespace == indentLevel) {
        // Consume all except the non-WHITE_SPACE char
        yypushback(1);
        yybegin(MAIN);
        return FregeTokenTypes.WHITE_SPACE;
      }
      if (numWhitespace > indentLevel) {
        // Consume up to the indentLevel + 1 for the INDENT
        currentLineIndent = indentLevel + 1;
        yypushback(yylength() - (indentLevel + 1));
        return FregeTokenTypes.INDENT;
      }
      if (numWhitespace < indentLevel) {
        --indentLevel;
        yypushback(yylength());
        return FregeTokenTypes.DEDENT;
      }
      // Shouldn't happen since we checked ==, >, and <
      throw new AssertionError(
        "Unexpected case: numWhitespace: " + numWhitespace + "; "
          + "indentLevel: " + indentLevel
      );
    }

    // If no more whitespace, start the line.
    if (numWhitespace == 0) {
      indentLevel = currentLineIndent;
      currentLineIndent = 0;
      yypushback(1);
      yybegin(MAIN);
      return FregeTokenTypes.WHITE_SPACE;
    }

    // If there is whitespace, consume it one char at a time.
    ++currentLineIndent;
    // Consume 1 WHITE_SPACE char.
    yypushback(yylength() - 1);
    return FregeTokenTypes.INDENT;
  }
}

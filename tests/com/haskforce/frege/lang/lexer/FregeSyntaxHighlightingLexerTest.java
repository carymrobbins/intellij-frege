package com.haskforce.frege.lang.lexer;

import com.intellij.lexer.Lexer;
import com.haskforce.frege.lang.parser.FregeParsingTestCases;
import org.jetbrains.annotations.NotNull;

/**
 * Frege syntax highlighting lexer tests.
 *
 * Each method name corresponds to a file in 'tests/gold/parser'
 * The lexer will lex the file then compare its results with the corresponding
 * file in 'tests/gold/parser/lexer/expected'.  If that file does not exist, the file will
 * be automatically generated from the lexer results.
 */
public class FregeSyntaxHighlightingLexerTest
  extends FregeLexerTestBase
  implements FregeParsingTestCases {

  @NotNull @Override protected String getExpectedPath() {
    return "highlighter";
  }

  @Override protected Lexer createLexer() {
    return new FregeSyntaxHighlightingLexer();
  }

  public void testExample00001() { doTest(); }
  public void testExample00002() { doTest(); }
  public void testInvalid00001() { doTest(); }
  public void testNative00001() { doTest(); }
}

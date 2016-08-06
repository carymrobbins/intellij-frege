package com.haskforce.frege.lang.lexer;

import com.intellij.lexer.Lexer;
import com.haskforce.frege.lang.parser.FregeParsingTestCases;
import org.jetbrains.annotations.NotNull;

/**
 * Frege parsing lexer tests.
 *
 * Each method name corresponds to a file in 'tests/gold/parser'
 * The lexer will lex the file then compare its results with the corresponding
 * file in 'tests/gold/parser/lexer/expected'.  If that file does not exist, the file will
 * be automatically generated from the lexer results.
 */
public class FregeParsingLexerTest extends FregeLexerTestBase {

  @NotNull @Override protected String getExpectedPath() {
    return "lexer";
  }

  @Override protected Lexer createLexer() {
    return new FregeParsingLexer();
  }

  public void testError00001() { doTest(); }
  public void testExample00001() { doTest(); }
  public void testExample00002() { doTest(); }
  public void testNative00001() { doTest(); }
}

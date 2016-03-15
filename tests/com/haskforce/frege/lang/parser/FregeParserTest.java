package com.haskforce.frege.lang.parser;

/** Tests for the Frege parser. */
public class FregeParserTest extends FregeParserTestBase {
  public FregeParserTest() {
    super("parser", "fr", new FregeParserDefinition());
  }

  public void testBlank00001() { doTest(); }
  public void testExample00001() { doTest(); }
  public void testExample00002() { doTest(); }
  public void testInvalid00001() { doTest(); }
  public void testNative00001() { doTest(); }
}

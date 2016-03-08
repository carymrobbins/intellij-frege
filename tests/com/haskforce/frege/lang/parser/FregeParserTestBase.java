package com.haskforce.frege.lang.parser;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.testFramework.ParsingTestCase;

/** Helper class for defining Frege parser tests. */
public abstract class FregeParserTestBase extends ParsingTestCase {

  FregeParserTestBase() {
    super(FileUtil.join("frege", "parser"), "fr", false, new FregeParserDefinition());
  }

  protected void doTest() {
    doTest(true);
  }

  @Override
  protected String getTestDataPath() {
    return FileUtil.join("tests", "gold");
  }

  @Override
  protected boolean skipSpaces() {
    return true;
  }
}

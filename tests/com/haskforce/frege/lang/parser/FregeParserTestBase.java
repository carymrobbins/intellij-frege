package com.haskforce.frege.lang.parser;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.ParsingTestCase;
import org.jetbrains.annotations.NonNls;

import java.io.IOException;

/** Helper class for defining Frege parser tests. */
public abstract class FregeParserTestBase extends ParsingTestCase {

  FregeParserTestBase() {
    super(FileUtil.join("frege", "parser"), "fr", false, new FregeParserDefinition());
  }

  void doTest() {
    doTest(true);
  }

  @Override
  protected String getTestDataPath() {
    return FileUtil.join("testData");
  }

  @Override
  protected boolean skipSpaces() {
    return true;
  }

  @Override
  protected void checkResult(@NonNls String targetDataName, PsiFile file) throws IOException {
    super.checkResult(FileUtil.join("expected", targetDataName), file);
  }
}

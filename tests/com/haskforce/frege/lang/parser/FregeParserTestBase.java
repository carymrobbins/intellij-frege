package com.haskforce.frege.lang.parser;

import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.testFramework.ParsingTestCase;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.TestDataFile;
import junit.framework.AssertionFailedError;
import org.jetbrains.annotations.NonNls;

import java.io.File;
import java.io.IOException;

public abstract class FregeParserTestBase extends ParsingTestCase {
  public FregeParserTestBase(String dataPath, String fileExt, ParserDefinition... definitions) {
    super(dataPath, fileExt, definitions);
  }

  @Override
  protected String getTestDataPath() {
    return FileUtil.join("tests", "gold", "frege");
  }

  @Override
  protected boolean skipSpaces() {
    return true;
  }

  /**
   * Perform a test. Add tests that should work but does not work yet with
   * doTest(false, false).
   */
  protected void doTest() {
    // Do some gymnastics to see if we had to create the comparison file.
    // This is convenient so we can tell if the generated file has error elements or not.
    AssertionFailedError noComparisonTextFound = null;
    try {
      doTest(true);
    } catch (AssertionFailedError e) {
      if (e.getMessage().startsWith("No output text found")) {
        noComparisonTextFound = e;
      } else {
        throw e;
      }
    }
    // If we had to create the comparison file, be sure to say that but explain
    // that there are error elements in the created file.  Otherwise, just report
    // that the existing file had error elements.
    final String message = noComparisonTextFound != null
      ? noComparisonTextFound.getMessage() + " (but contains error elements)"
      : "PsiFile contains error elements";
    assertFalse(message,
      toParseTreeText(myFile, skipSpaces(), includeRanges()).contains("PsiErrorElement")
    );
    // If we had to create a comparison file, be sure to fail the test but report that
    // error elements were not found.
    if (noComparisonTextFound != null) {
      fail(noComparisonTextFound.getMessage() + " (but no error elements found)");
    }
  }

  /*
   * Ensure that expected outputs live in some other directory than the test
   * inputs.
   *
   * Additionally this function performs the JSON parser test because this
   * is a convenient place to hook into the testing.
   *
   * Expected outputs go <path>/<component>/expected/, putting the parser
   * outputs in tests/gold/parser/expected
   */
  @Override
  protected void checkResult(@NonNls @TestDataFile String targetDataName,
                             final PsiFile file) throws IOException {
    doCheckResult(myFullDataPath, file, checkAllPsiRoots(),
      "expected" + File.separator + targetDataName, skipSpaces(),
      includeRanges());
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }
}


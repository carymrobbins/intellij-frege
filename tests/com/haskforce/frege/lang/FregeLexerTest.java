package com.haskforce.frege.lang;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.rt.execution.junit.FileComparisonFailure;
import com.intellij.testFramework.LexerTestCase;
import com.intellij.testFramework.TestDataFile;
import com.intellij.testFramework.VfsTestUtil;
import org.jetbrains.annotations.NonNls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Frege lexer tests.
 *
 * Each method name corresponds to a file in 'tests/gold/parser'
 * The lexer will lex the file then compare its results with the corresponding
 * file in 'tests/gold/parser/lexer/expected'.  If that file does not exist, the file will
 * be automatically generated from the lexer results.
 */
public class FregeLexerTest extends LexerTestCase {

  public void testExample00001() { doTest(); }
  public void testExample00002() { doTest(); }
  public void testNative00001() { doTest(); }

  /////////////////////////////////////////////////

  @Override
  protected Lexer createLexer() {
    return new FregeLexer();
  }

  @Override
  protected String getDirPath() {
    return FileUtil.join("tests", "gold", "parser");
  }

  public void doTest() {
    String fileName = getTestName(false) + ".fr";
    String text = "";
    try {
      text = loadFile(fileName);
    } catch (IOException e) {
      fail("can't load file " + fileName + ": " + e.getMessage());
    }
    String result = printTokens(text, 0);
    String expectedPath = FileUtil.join(getDirPath(), "lexer", "expected");
    try {
      doCheckResult(expectedPath, getTestName(false) + ".txt", result);
    } catch (IOException e) {
      fail("Unexpected IO Exception: " + e.getMessage());
    }
  }

  /**
   * Loads the test data file from the right place.
   */
  protected String loadFile(@NonNls @TestDataFile String name) throws IOException {
    return doLoadFile(getDirPath(), name);
  }

  private static String doLoadFile(String myFullDataPath, String name) throws IOException {
    String text = FileUtil.loadFile(new File(myFullDataPath, name), CharsetToolkit.UTF8).trim();
    text = StringUtil.convertLineSeparators(text);
    return text;
  }

  /**
   * Check the result against a plain text file. Creates file if missing.
   * Avoids the default sandboxing in IntelliJ.
   */
  public static void doCheckResult(String fullPath, String targetDataName, String text) throws IOException {
    text = text.trim();
    String expectedFileName = fullPath + File.separator + targetDataName;
    if (OVERWRITE_TESTDATA) {
      VfsTestUtil.overwriteTestData(expectedFileName, text);
      System.out.println("File " + expectedFileName + " created.");
    }
    try {
      String expectedText = doLoadFile(fullPath, targetDataName);
      if (!Comparing.equal(expectedText, text)) {
        throw new FileComparisonFailure(targetDataName, expectedText, text, expectedFileName);
      }
    } catch (FileNotFoundException e) {
      VfsTestUtil.overwriteTestData(expectedFileName, text);
      fail("No output text found. File " + expectedFileName + " created.");
    }
  }
}

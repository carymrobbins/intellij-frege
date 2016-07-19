package com.haskforce.frege.lang.lexer;

import com.intellij.lang.TokenWrapper;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.psi.tree.IElementType;
import com.intellij.rt.execution.junit.FileComparisonFailure;
import com.intellij.testFramework.LexerTestCase;
import com.intellij.testFramework.TestDataFile;
import com.intellij.testFramework.VfsTestUtil;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/** Helper class for defining Frege lexer tests. */
public abstract class FregeLexerTestBase extends LexerTestCase {

  @NotNull
  protected abstract String getExpectedPath();

  @Override
  final protected String getDirPath() {
    return FileUtil.join("testData", "frege", "parser");
  }

  public void doTest() {
    String fileName = getTestName(false) + ".fr";
    String text = "";
    try {
      text = loadFile(fileName);
    } catch (IOException e) {
      fail("can't load file " + fileName + ": " + e.getMessage());
    }
    checkSegments(text, createLexer());
    String result = printTokensExtra(text, 0);
    String expectedPath = FileUtil.join(getDirPath(), getExpectedPath(), "expected");
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

  /** Ensures that there are no gaps between lexer tokens. */
  public static void checkSegments(CharSequence text, Lexer lexer) {
    lexer.start(text, 0, text.length());
    IElementType tokenType = lexer.getTokenType();
    assertNotNull("tokenType was null", tokenType);
    int lastEnd = -1;
    while (true) {
      if (lastEnd == -1) {
        assertEquals(0, lexer.getTokenStart());
      } else {
        assertEquals(lastEnd, lexer.getTokenStart());
      }
      lastEnd = lexer.getTokenEnd();
      lexer.advance();
      if (lexer.getTokenType() == null) break;
    }
  }

  /** Prints tokens with start and end offsets. */
  private String printTokensExtra(String text, int start) {
    return printTokensExtra(text, start, createLexer());
  }

  private String printTokensExtra(CharSequence text, int start, Lexer lexer) {
    lexer.start(text, start, text.length());
    String result = "";
    while (true) {
      IElementType tokenType = lexer.getTokenType();
      if (tokenType == null) {
        break;
      }
      String tokenText = getTokenText(lexer);
      String tokenTypeName = tokenType.toString();
      String line = tokenTypeName + " ('" + tokenText + "') " +
        lexer.getTokenStart() + "-" + lexer.getTokenEnd() + "\n";
      result += line;
      lexer.advance();
    }
    return result;
  }

  /** Copy pasta from LexerTestCase.getTokenText. */
  private String getTokenText(Lexer lexer) {
    final IElementType tokenType = lexer.getTokenType();
    if (tokenType instanceof TokenWrapper) {
      return ((TokenWrapper)tokenType).getValue();
    }

    String text = lexer.getBufferSequence().subSequence(lexer.getTokenStart(), lexer.getTokenEnd()).toString();
    text = StringUtil.replace(text, "\n", "\\n");
    return text;
  }
}

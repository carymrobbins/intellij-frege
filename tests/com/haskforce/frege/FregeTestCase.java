package com.haskforce.frege;

import com.haskforce.frege.lang.java.FregeResolveFromJavaTest;
import com.haskforce.frege.lang.lexer.FregeParsingLexerTest;
import com.haskforce.frege.lang.lexer.FregeSyntaxHighlightingLexerTest;
import com.haskforce.frege.lang.parser.FregeParserTest;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FregeTestCase extends TestCase {
    public static TestSuite suite() {
      TestSuite s = new TestSuite();
      // Parsing test cases
      s.addTestSuite(FregeSyntaxHighlightingLexerTest.class);
      s.addTestSuite(FregeParsingLexerTest.class);
      s.addTestSuite(FregeParserTest.class);
      // Resolve test cases
      s.addTestSuite(FregeResolveFromJavaTest.class);
      return s;
    }
}

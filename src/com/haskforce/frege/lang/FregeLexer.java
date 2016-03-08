package com.haskforce.frege.lang;

import com.intellij.lexer.FlexAdapter;

/**
 * The IntelliJ lexer for Frege files.
 *
 * Uses the FregeFlexLexer which is a wrapper around Frege's internal lexer.
 */
public class FregeLexer extends FlexAdapter {
  public FregeLexer() {
    super(new FregeFlexLexer());
  }
}

package com.haskforce.frege.lang.lexer;

import com.intellij.lexer.FlexAdapter;

/** Lexer used specifically for syntax highlighting. */
public class FregeSyntaxHighlightingLexer extends FlexAdapter {
  public FregeSyntaxHighlightingLexer() {
    super(new _FregeSyntaxHighlightingLexer());
  }
}

package com.haskforce.frege.lang.lexer;

import com.intellij.lexer.FlexAdapter;

/**
 * The IntelliJ lexer for Frege files.
 *
 * Uses the FregeFlexParsingLexer which is a wrapper around Frege's internal lexer.
 * This is used specifically for parsing and NOT syntax highlighting.
 */
public class FregeParsingLexer extends FlexAdapter {

  public FregeParsingLexer() {
    super(new FregeFlexParsingLexer());
  }

  @Override
  public FregeFlexParsingLexer getFlex() {
    return (FregeFlexParsingLexer)super.getFlex();
  }
}

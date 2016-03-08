package com.haskforce.frege.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import frege.compiler.grammar.Lexer;
import frege.compiler.types.Tokens;
import frege.prelude.PreludeBase;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

/**
 * Flex wrapper around the Frege Lexer.
 *
 * This class provides us a way to reuse Frege's internal Lexer in the context of IntelliJ.
 * It is used by FregeLexer (a FlexAdapter) to convert this flex-like interface into something
 * IntelliJ can use.
 */
public class FregeFlexLexer implements FlexLexer {

  // Result values from the Frege Lexer.
  private PreludeBase.TList lexList;
  private @Nullable Tokens.TToken lexToken;

  /* The Frege Lexer doesn't seem to need state, so this method does nothing. */
  public void yybegin(int state) {}

  /** Just like yybegin(), this method does nothing but simply return zero. */
  @Override
  public int yystate() {
    // Again, this is not used by the Frege Lexer.
    return 0;
  }

  /** If we have a current token, get its offset; otherwise, return zero. */
  @Override
  public int getTokenStart() {
    if (lexToken == null) return 0;
    return lexToken.mem$offset;
  }

  /** If we have a current token, get its ending offset; otherwise, return zero. */
  @Override
  public int getTokenEnd() {
    if (lexToken == null) return 0;
    return lexToken.mem$offset + lexToken.mem$value.length();
  }

  /** Advances the Frege Lexer by just moving to the next element in the list.  */
  @Override
  public IElementType advance() throws IOException {
    PreludeBase.TList.DCons lexCons = lexList._Cons();
    if (lexCons == null) {
      lexToken = null;
      return null;
    }
    lexToken = (Tokens.TToken)lexCons.mem1;
    lexList = lexCons.mem2.<PreludeBase.TList>forced();
    return new FregeTokenType(lexToken);
  }

  /** Starts the Frege Lexer at the beginning of the input buffer. */
  @Override
  public void reset(CharSequence buf, int start, int end, int initialState) {
    lexList = Lexer.lex(buf, 0, 0, start).<PreludeBase.TList>forced();
  }
}

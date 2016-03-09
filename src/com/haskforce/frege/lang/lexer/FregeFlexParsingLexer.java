package com.haskforce.frege.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
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
 * It is used by FregeParsingLexer (a FlexAdapter) to convert this flex-like interface into something
 * IntelliJ can use.
 */
public class FregeFlexParsingLexer implements FlexLexer {

  // Result values from the Frege Lexer.
  private CharSequence buffer;
  private PreludeBase.TList remainingTokens;
  private int tokenStart;
  private int tokenEnd;
  private boolean isReset = false;

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
    return tokenStart;
  }

  /** If we have a current token, get its ending offset; otherwise, return the file end offset. */
  @Override
  public int getTokenEnd() {
    return tokenEnd;
  }

  /** Advances the Frege Lexer by just moving to the next element in the list.  */
  @Override
  public IElementType advance() throws IOException {
    Tokens.TToken nextToken = peekNext();

    // Whitespace-only file
    if (isReset && nextToken == null) {
      tokenEnd = buffer.length();
      return TokenType.WHITE_SPACE;
    }

    isReset = false;

    // End of lexer tokens.
    if (nextToken == null) {
      if (tokenEnd < buffer.length()) {
        tokenStart = tokenEnd;
        tokenEnd = buffer.length();
        return TokenType.WHITE_SPACE;
      }
      return null;
    }

    // Inject whitespace tokens
    if (tokenEnd < nextToken.mem$offset) {
      tokenStart = tokenEnd;
      tokenEnd = nextToken.mem$offset;
      return TokenType.WHITE_SPACE;
    }

    tokenStart = nextToken.mem$offset;
    tokenEnd = nextToken.mem$offset + Tokens.TToken.length(nextToken);

    PreludeBase.TList.DCons lexCons = remainingTokens._Cons();
    // This shouldn't be null since we've already peeked at the next token.
    if (lexCons == null) throw new RuntimeException("lexCons was unexpectedly null");
    remainingTokens = lexCons.mem2.<PreludeBase.TList>forced();

    return FregeTokenTypes.fromToken(nextToken);
  }

  /** Starts the Frege Lexer at the beginning of the input buffer. */
  @Override
  public void reset(CharSequence buf, int start, int end, int initialState) {
    // Ignoring start and end
    isReset = true;
    buffer = buf;
    remainingTokens = Lexer.lex(buffer, 0, 0, 0).<PreludeBase.TList>forced();
    tokenStart = 0;
    tokenEnd = 0;
  }

  @Nullable
  private Tokens.TToken peekNext() {
    PreludeBase.TList.DCons cons = remainingTokens._Cons();
    if (cons == null) return null;
    if (cons.mem1 instanceof Tokens.TToken) return (Tokens.TToken)cons.mem1;
    // TODO: How is this possible?
    System.err.println("cons.mem1 is not a TToken: " + cons.mem1);
    return null;
  }

  /** Method used for debugging tokens from Frege's Lexer. */
  private void printTokens() {
    PreludeBase.TList.DCons cons = remainingTokens._Cons();
    System.out.println("********* tokens ==> [");
    while (cons != null) {
      Tokens.TToken token = (Tokens.TToken) cons.mem1;
      System.out.println(
        "  " + token.mem$offset + "-" + (token.mem$offset + Tokens.TToken.length(token)) + ": " + token.mem$value
      );
      cons = cons.mem2.<PreludeBase.TList>forced()._Cons();
    }
    System.out.println("]");
  }
}

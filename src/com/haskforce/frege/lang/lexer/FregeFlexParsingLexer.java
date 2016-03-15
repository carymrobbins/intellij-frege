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
  private PreludeBase.TList<Tokens.TToken> lexerTokens;
  private PreludeBase.TList remainingTokens;
  private int tokenStart;
  private int tokenEnd;
  private boolean isReset = false;

  public PreludeBase.TList<Tokens.TToken> getLexerTokens() {
    return lexerTokens;
  }

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
    // Skip any tokens that are on the same offset.  These may be synthetic tokens.
    // NOTE: The PsiParser will have to properly handle this behavior!
    while (nextToken != null && nextToken.mem$offset == tokenStart) {
      advanceToken();
      nextToken = peekNext();
    }

    // Whitespace-only file
    if (isReset && nextToken == null) {
      isReset = false;
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
    if (tokenEnd < nextToken.mem$offset && nextToken.mem$offset != Integer.MAX_VALUE) {
      tokenStart = tokenEnd;
      tokenEnd = nextToken.mem$offset;
      return TokenType.WHITE_SPACE;
    }

    if (nextToken.mem$offset == Integer.MAX_VALUE) {
      // This happens with an inferred closing brace at the end of the source file.
      tokenStart = tokenEnd;
      tokenEnd = buffer.length();
//      atEnd = true;
    } if (isSynthetic(nextToken)) {
      // Synthetic tokens should have zero length.
      tokenStart = tokenEnd;
    } else {
      tokenStart = nextToken.mem$offset;
      tokenEnd = nextToken.mem$offset + Tokens.TToken.length(nextToken);
    }

    advanceToken();
    return FregeTokenTypes.fromToken(nextToken);
  }

  /** Starts the Frege Lexer at the beginning of the input buffer. */
  @Override
  public void reset(CharSequence buf, int start, int end, int initialState) {
    // Ignoring start and end
    isReset = true;
    buffer = buf;
    lexerTokens = Lexer.lexer(buffer).call();
    remainingTokens = lexerTokens.call();
    tokenStart = 0;
    tokenEnd = 0;
  }

  @Nullable
  private Tokens.TToken peekNext() {
    PreludeBase.TList.DCons cons = remainingTokens.asCons();
    if (cons == null) return null;
    Object tok = cons.mem1.call();
    if (tok instanceof Tokens.TToken) return (Tokens.TToken)tok;
    throw new RuntimeException("tok is not a TToken: " + tok);
  }

  private void advanceToken() {
    PreludeBase.TList.DCons lexCons = remainingTokens.asCons();
    // This shouldn't be null since we've already peeked at the next token.
    if (lexCons == null) throw new RuntimeException("lexCons was unexpectedly null");
    remainingTokens = (PreludeBase.TList)lexCons.mem2.call();
  }

  public static boolean isSynthetic(Tokens.TToken token) {
    return token.mem$col == 0;
  }

  /** Method used for debugging tokens from Frege's Lexer. */
  public void printTokens(int id) {
    PreludeBase.TList.DCons<Tokens.TToken> cons = lexerTokens.asCons();
    System.out.println("********* [" + id + "] tokens ==> [");
    while (cons != null) {
      Tokens.TToken token = cons.mem1.call();
      System.out.println(
        // "  [" + id + "] TOKEN <<< " + Tokens.IShow_Token.show(token) + " >>> " + token.mem$offset + "-" + (token.mem$offset + Tokens.TToken.length(token)) + ": " + token.mem$value
        Tokens.IShow_Token.show(token)
      );
      cons = (cons.mem2.call()).asCons();
    }
    System.out.println("]");
  }
}

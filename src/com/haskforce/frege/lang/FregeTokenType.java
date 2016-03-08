package com.haskforce.frege.lang;

import com.intellij.psi.tree.IElementType;
import frege.compiler.enums.TokenID;
import frege.compiler.types.Tokens;

/** Allows Frege's internal Token values to be used as IntelliJ's IElementType for lexing. */
public class FregeTokenType extends IElementType {
  public FregeTokenType(Tokens.TToken token) {
    // Use the TokenID name as the token's debugName, which is used for toString().
    super(TokenID.IShow_TokenID.show(token.mem$tokid), FregeLanguage.INSTANCE);
  }
}

package com.haskforce.frege.lang.psi;

import com.haskforce.frege.lang.FregeLanguage;
import com.intellij.psi.tree.IElementType;

/** Base type for all Frege lexer tokens. */
public class FregeTokenType extends IElementType {
  public FregeTokenType(String name) {
    super(name, FregeLanguage.INSTANCE);
  }
}

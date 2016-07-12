package com.haskforce.frege.lang.psi;

import com.haskforce.frege.lang.FregeLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FregeElementType extends IElementType {
  public FregeElementType(@NotNull @NonNls String debugName) {
    super(debugName, FregeLanguage.INSTANCE);
  }
}

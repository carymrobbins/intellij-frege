package com.haskforce.frege.lang.psi.stubs;

import com.haskforce.frege.lang.FregeLanguage;
import com.haskforce.frege.lang.psi.FregeCompositeElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public abstract class FregeStubElementType
  <S extends StubElement<T>, T extends FregeCompositeElement>
  extends IStubElementType<S, T> {

  public FregeStubElementType(@NotNull @NonNls String debugName) {
    super(debugName, FregeLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getExternalId() {
    return "frege." + super.toString();
  }
}

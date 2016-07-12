package com.haskforce.frege.lang.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.NamedStubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.NotNull;

public class FregeModuleNameStub extends NamedStubBase<FregeModuleName> {

  protected FregeModuleNameStub(
    StubElement parent, @NotNull IStubElementType elementType, StringRef name
  ) {
    super(parent, elementType, name);
  }
}

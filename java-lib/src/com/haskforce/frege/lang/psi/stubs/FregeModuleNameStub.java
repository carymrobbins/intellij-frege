package com.haskforce.frege.lang.psi.stubs;

import com.haskforce.frege.lang.psi.impl.FregeModuleName;
import com.haskforce.frege.utils.ClassUtils;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.NamedStubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.NotNull;

public class FregeModuleNameStub
  extends NamedStubBase<FregeModuleName> {

  private final StringRef qualName;
  private final StringRef shortName;

  FregeModuleNameStub(StubElement parent, @NotNull IStubElementType elementType,
                      StringRef qualName, StringRef shortName) {
    super(parent, elementType, shortName);
    this.qualName = qualName;
    this.shortName = shortName;
  }

  FregeModuleNameStub(StubElement parent, @NotNull IStubElementType elementType,
                      String qualName, String shortName) {
    this(parent, elementType, StringRef.fromString(qualName), StringRef.fromString(shortName));
  }

  @NotNull
  public String getQualifiedName() {
    return qualName.getString();
  }

  @NotNull
  public String getPackageName() {
    return ClassUtils.getPackageName(qualName.getString());
  }

  @Override
  @NotNull
  public String getName() {
    return shortName.getString();
  }
}

package com.haskforce.frege.lang.psi.stubs;

import com.haskforce.frege.index.FregeIndexKeys;
import com.haskforce.frege.lang.psi.FregeTokenTypes;
import com.haskforce.frege.lang.psi.impl.FregeModuleName;
import com.intellij.lang.ASTNode;
import com.intellij.psi.impl.java.stubs.index.JavaStubIndexKeys;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class FregeModuleNameStubElementType
  extends FregeStubElementType<FregeModuleNameStub, FregeModuleName> {

  public FregeModuleNameStubElementType(@NotNull @NonNls String debugName) {
    super(debugName);
  }

  @Override
  public FregeModuleName createPsi(@NotNull FregeModuleNameStub stub) {
    return new FregeModuleName(stub, this);
  }

  @Override
  public boolean shouldCreateStub(ASTNode node) {
    // Only create the stub if we are in a declaration.
    return node.getTreeParent().getElementType() == FregeTokenTypes.MODULE_DECL;
  }

  @Override
  public FregeModuleNameStub createStub(@NotNull FregeModuleName psi, StubElement parentStub) {
    return new FregeModuleNameStub(parentStub, this, psi.getQualifiedName(), psi.getName());
  }

  @Override
  public void serialize(@NotNull FregeModuleNameStub stub, @NotNull StubOutputStream dataStream) throws IOException {
    dataStream.writeName(stub.getQualifiedName());
    dataStream.writeName(stub.getName());
  }

  @NotNull
  @Override
  public FregeModuleNameStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
    StringRef qualName = dataStream.readName();
    StringRef name = dataStream.readName();
    return new FregeModuleNameStub(parentStub, this, qualName, name);
  }

  @Override
  public void indexStub(@NotNull FregeModuleNameStub stub, @NotNull IndexSink sink) {
    sink.occurrence(FregeIndexKeys.MODULE_QUALIFIED_NAMES, stub.getQualifiedName());
    sink.occurrence(FregeIndexKeys.MODULE_SHORT_NAMES, stub.getName());
    sink.occurrence(FregeIndexKeys.ALL_CLASS_NAMES, stub.getName());
    sink.occurrence(FregeIndexKeys.CLASSES_IN_PACKAGES, stub.getPackageName());
  }
}

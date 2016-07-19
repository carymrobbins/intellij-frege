package com.haskforce.frege.lang.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;

public abstract class FregeNamedStubbedPsiElementBase<T extends StubElement<?>>
  extends FregeStubbedPsiElementBase<T>
  implements FregeCompositeElement {

  public FregeNamedStubbedPsiElementBase(@NotNull T stub, @NotNull IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public FregeNamedStubbedPsiElementBase(@NotNull ASTNode node) {
    super(node);
  }
}

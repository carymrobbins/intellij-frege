package com.haskforce.frege.index;

import com.intellij.psi.PsiClass;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import org.jetbrains.annotations.NotNull;

public final class FregeQualifiedModuleNameIndex extends StringStubIndexExtension<PsiClass> {
  @NotNull
  @Override
  public StubIndexKey<String, PsiClass> getKey() {
    return FregeIndexKeys.MODULE_QUALIFIED_NAMES;
  }
}

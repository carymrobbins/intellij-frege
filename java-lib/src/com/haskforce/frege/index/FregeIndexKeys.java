package com.haskforce.frege.index;

import com.intellij.psi.PsiClass;
import com.intellij.psi.stubs.StubIndexKey;

public abstract class FregeIndexKeys {

  public static final StubIndexKey<String, PsiClass> MODULE_QUALIFIED_NAMES =
    StubIndexKey.createIndexKey("frege.module.names");

  public static final StubIndexKey<String, PsiClass> MODULE_SHORT_NAMES =
    StubIndexKey.createIndexKey("frege.qualified.module.names");

  public static final StubIndexKey<String, PsiClass> ALL_CLASS_NAMES =
    StubIndexKey.createIndexKey("frege.all.class.names");
}

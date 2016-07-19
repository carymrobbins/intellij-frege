package com.haskforce.frege.lang.psi;

import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNameIdentifierOwner;

public interface FregeNamedElement
  extends FregeCompositeElement, NavigationItem, PsiNameIdentifierOwner {
}

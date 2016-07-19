package com.haskforce.frege.lang.psi.ref;

import com.haskforce.frege.lang.FregeLanguage;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class FregeReferenceProvider extends PsiReferenceProvider {
  @NotNull
  @Override
  public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                               @NotNull ProcessingContext context) {
    if (!element.getLanguage().is(FregeLanguage.INSTANCE)) return PsiReference.EMPTY_ARRAY;
    if (!(element instanceof PsiNamedElement)) return PsiReference.EMPTY_ARRAY;
    PsiNamedElement named = (PsiNamedElement) element;
    return new PsiReference[]{new FregeReference(named, named.getTextRange())};
  }
}

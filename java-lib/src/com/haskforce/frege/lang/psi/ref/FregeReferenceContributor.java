package com.haskforce.frege.lang.psi.ref;

import com.haskforce.frege.lang.FregeLanguage;
import com.haskforce.frege.lang.psi.impl.FregeModuleName;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import org.jetbrains.annotations.NotNull;

public class FregeReferenceContributor extends PsiReferenceContributor {
  @Override
  public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
    registrar.registerReferenceProvider(capture, new FregeReferenceProvider());
  }

  private static PsiElementPattern.Capture<PsiNamedElement> capture =
      PlatformPatterns.psiElement(PsiNamedElement.class)
        .withParent(FregeModuleName.class)
        .withLanguage(FregeLanguage.INSTANCE);
}

package com.haskforce.frege.lang.java;

import com.haskforce.frege.index.FregeIndexKeys;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElementFinder;
import com.intellij.psi.PsiPackage;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class FregeElementFinder extends PsiElementFinder {

  private final @NotNull Project project;

  public FregeElementFinder(@NotNull Project project) {
    this.project = project;
  }

  @NotNull
  @Override
  public PsiClass[] getClasses(@NotNull PsiPackage psiPackage, @NotNull GlobalSearchScope scope) {
    return StubIndex.getElements(
      FregeIndexKeys.CLASSES_IN_PACKAGES, psiPackage.getQualifiedName(),
      project,
      scope,
      PsiClass.class
    ).stream().toArray(PsiClass[]::new);
  }

  @Nullable
  @Override
  public PsiClass findClass(@NotNull String qualifiedName, @NotNull GlobalSearchScope scope) {
    return fetch(qualifiedName, scope).findFirst().orElse(null);
  }

  @NotNull
  @Override
  public PsiClass[] findClasses(@NotNull String qualifiedName, @NotNull GlobalSearchScope scope) {
    return fetch(qualifiedName, scope).toArray(PsiClass[]::new);
  }

  @NotNull
  private Stream<PsiClass> fetch(@NotNull String qualifiedName, @NotNull GlobalSearchScope scope) {
    return StubIndex.getElements(
      FregeIndexKeys.MODULE_QUALIFIED_NAMES, qualifiedName,
      project,
      scope,
      PsiClass.class
    ).stream();
  }
}

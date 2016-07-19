package com.haskforce.frege.lang.java;

import com.haskforce.frege.index.FregeIndexKeys;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElementFinder;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class FregeElementFinder extends PsiElementFinder {

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
  private static Stream<PsiClass> fetch(@NotNull String qualifiedName,
                                        @NotNull GlobalSearchScope scope) {
    if (scope.getProject() == null) return Stream.empty();
    return StubIndex.getElements(
      FregeIndexKeys.MODULE_QUALIFIED_NAMES, qualifiedName,
      scope.getProject(),
      scope,
      PsiClass.class
    ).stream();
  }
}

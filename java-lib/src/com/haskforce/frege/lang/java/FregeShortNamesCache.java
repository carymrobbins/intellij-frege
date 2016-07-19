package com.haskforce.frege.lang.java;

import com.haskforce.frege.index.FregeIndexKeys;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiShortNamesCache;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.util.Processor;
import com.intellij.util.containers.HashSet;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class FregeShortNamesCache extends PsiShortNamesCache {

  private final Project project;

  public FregeShortNamesCache(@NotNull Project project) {
    this.project = project;
  }

  @NotNull
  @Override
  public PsiClass[] getClassesByName(@NotNull @NonNls String name, @NotNull GlobalSearchScope scope) {
    if (scope.getProject() == null) return PsiClass.EMPTY_ARRAY;
    return StubIndex.getElements(
      FregeIndexKeys.MODULE_SHORT_NAMES, name,
      project,
      scope,
      PsiClass.class
    ).stream().toArray(PsiClass[]::new);
  }

  @NotNull
  @Override
  public String[] getAllClassNames() {
    return allClassNames().stream().toArray(String[]::new);
  }

  @Override
  public void getAllClassNames(@NotNull HashSet<String> dest) {
    dest.addAll(allClassNames());
  }

  private Collection<String> allClassNames() {
    return StubIndex.getInstance().getAllKeys(
      FregeIndexKeys.ALL_CLASS_NAMES, project
    );
  }

  // Stubbed methods not yet implemented.

  @NotNull
  @Override
  public PsiMethod[] getMethodsByName(@NonNls @NotNull String name, @NotNull GlobalSearchScope scope) {
    return new PsiMethod[0];
  }

  @NotNull
  @Override
  public PsiMethod[] getMethodsByNameIfNotMoreThan(@NonNls @NotNull String name, @NotNull GlobalSearchScope scope, int maxCount) {
    return new PsiMethod[0];
  }

  @NotNull
  @Override
  public PsiField[] getFieldsByNameIfNotMoreThan(@NonNls @NotNull String name, @NotNull GlobalSearchScope scope, int maxCount) {
    return new PsiField[0];
  }

  @Override
  public boolean processMethodsWithName(@NonNls @NotNull String name, @NotNull GlobalSearchScope scope, @NotNull Processor<PsiMethod> processor) {
    return false;
  }

  @NotNull
  @Override
  public String[] getAllMethodNames() {
    return new String[0];
  }

  @Override
  public void getAllMethodNames(@NotNull HashSet<String> set) {

  }

  @NotNull
  @Override
  public PsiField[] getFieldsByName(@NotNull @NonNls String name, @NotNull GlobalSearchScope scope) {
    return new PsiField[0];
  }

  @NotNull
  @Override
  public String[] getAllFieldNames() {
    return new String[0];
  }

  @Override
  public void getAllFieldNames(@NotNull HashSet<String> set) {

  }
}

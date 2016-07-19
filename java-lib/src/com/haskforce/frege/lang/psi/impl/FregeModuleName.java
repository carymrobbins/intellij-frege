package com.haskforce.frege.lang.psi.impl;

import com.haskforce.frege.lang.FregeIcons;
import com.haskforce.frege.lang.psi.FregeNamedStubbedPsiElementBase;
import com.haskforce.frege.lang.psi.FregeTokenTypes;
import com.haskforce.frege.lang.psi.stubs.FregeModuleNameStub;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.javadoc.PsiDocComment;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FregeModuleName
  extends FregeNamedStubbedPsiElementBase<FregeModuleNameStub>
  implements PsiClass, PsiIdentifier {

  public FregeModuleName(@NotNull FregeModuleNameStub stub, @NotNull IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public FregeModuleName(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String getName() {
    return getText();
  }

  @NotNull
  @Override
  public String getQualifiedName() {
    return FregePsiUtil.getModulePackage(this).map(x -> x.getText() + ".").orElse("") + getName();
  }

  @Nullable
  public String getPackageName() {
    PsiElement pkg = getParent().getFirstChild();
    if (pkg == null || !(pkg instanceof FregeModulePackage)) return null;
    return pkg.getText();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    // TODO: Name validation
    return replace(new FregeModuleName(new LeafPsiElement(FregeTokenTypes.IDENT, name)));
  }

  @Nullable
  @Override
  public PsiIdentifier getNameIdentifier() {
    return this;
  }

  @Override
  public IElementType getTokenType() {
    return getNode().getElementType();
  }

  @Override
  public ItemPresentation getPresentation() {
    // TODO: Use different icons for Frege 'module, 'data', etc.
    return ItemPresentationFactory.create(getName(), getPackageName(), FregeIcons.FILE);
  }

  // The following methods are stubbed to conform with PsiClass

  @Override
  public boolean isInterface() {
    return false;
  }

  @Override
  public boolean isAnnotationType() {
    return false;
  }

  @Override
  public boolean isEnum() {
    return false;
  }

  @Nullable
  @Override
  public PsiReferenceList getExtendsList() {
    return null;
  }

  @Nullable
  @Override
  public PsiReferenceList getImplementsList() {
    return null;
  }

  @NotNull
  @Override
  public PsiClassType[] getExtendsListTypes() {
    return new PsiClassType[0];
  }

  @NotNull
  @Override
  public PsiClassType[] getImplementsListTypes() {
    return new PsiClassType[0];
  }

  @Nullable
  @Override
  public PsiClass getSuperClass() {
    return null;
  }

  @Override
  public PsiClass[] getInterfaces() {
    return new PsiClass[0];
  }

  @NotNull
  @Override
  public PsiClass[] getSupers() {
    return new PsiClass[0];
  }

  @NotNull
  @Override
  public PsiClassType[] getSuperTypes() {
    return new PsiClassType[0];
  }

  @NotNull
  @Override
  public PsiField[] getFields() {
    return new PsiField[0];
  }

  @NotNull
  @Override
  public PsiMethod[] getMethods() {
    return new PsiMethod[0];
  }

  @NotNull
  @Override
  public PsiMethod[] getConstructors() {
    return new PsiMethod[0];
  }

  @NotNull
  @Override
  public PsiClass[] getInnerClasses() {
    return new PsiClass[0];
  }

  @NotNull
  @Override
  public PsiClassInitializer[] getInitializers() {
    return new PsiClassInitializer[0];
  }

  @NotNull
  @Override
  public PsiField[] getAllFields() {
    return new PsiField[0];
  }

  @NotNull
  @Override
  public PsiMethod[] getAllMethods() {
    return new PsiMethod[0];
  }

  @NotNull
  @Override
  public PsiClass[] getAllInnerClasses() {
    return new PsiClass[0];
  }

  @Nullable
  @Override
  public PsiField findFieldByName(@NonNls String name, boolean checkBases) {
    return null;
  }

  @Nullable
  @Override
  public PsiMethod findMethodBySignature(PsiMethod patternMethod, boolean checkBases) {
    return null;
  }

  @NotNull
  @Override
  public PsiMethod[] findMethodsBySignature(PsiMethod patternMethod, boolean checkBases) {
    return new PsiMethod[0];
  }

  @NotNull
  @Override
  public PsiMethod[] findMethodsByName(@NonNls String name, boolean checkBases) {
    return new PsiMethod[0];
  }

  @NotNull
  @Override
  public List<Pair<PsiMethod, PsiSubstitutor>> findMethodsAndTheirSubstitutorsByName(@NonNls String name, boolean checkBases) {
    return Collections.emptyList();
  }

  @NotNull
  @Override
  public List<Pair<PsiMethod, PsiSubstitutor>> getAllMethodsAndTheirSubstitutors() {
    return Collections.emptyList();
  }

  @Nullable
  @Override
  public PsiClass findInnerClassByName(@NonNls String name, boolean checkBases) {
    return null;
  }

  @Nullable
  @Override
  public PsiElement getLBrace() {
    return null;
  }

  @Nullable
  @Override
  public PsiElement getRBrace() {
    return null;
  }

  @Override
  public PsiElement getScope() {
    return null;
  }

  @Override
  public boolean isInheritor(@NotNull PsiClass baseClass, boolean checkDeep) {
    return false;
  }

  @Override
  public boolean isInheritorDeep(PsiClass baseClass, @Nullable PsiClass classToByPass) {
    return false;
  }

  @Nullable
  @Override
  public PsiClass getContainingClass() {
    return null;
  }

  @NotNull
  @Override
  public Collection<HierarchicalMethodSignature> getVisibleSignatures() {
    return Collections.emptyList();
  }

  @Nullable
  @Override
  public PsiDocComment getDocComment() {
    return null;
  }

  @Override
  public boolean isDeprecated() {
    return false;
  }

  @Override
  public boolean hasTypeParameters() {
    return false;
  }

  @Nullable
  @Override
  public PsiTypeParameterList getTypeParameterList() {
    return null;
  }

  @NotNull
  @Override
  public PsiTypeParameter[] getTypeParameters() {
    return new PsiTypeParameter[0];
  }

  @Nullable
  @Override
  public PsiModifierList getModifierList() {
    return null;
  }

  @Override
  public boolean hasModifierProperty(@PsiModifier.ModifierConstant @NonNls @NotNull String name) {
    return false;
  }
}

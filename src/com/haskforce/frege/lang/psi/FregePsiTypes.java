package com.haskforce.frege.lang.psi;

import com.haskforce.frege.lang.psi.impl.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public abstract class FregePsiTypes {

  // TODO: Generate this!
  public final static IElementType AnnDcl = new FregeElementType("AnnDcl");
  public final static IElementType Ann = new FregeElementType("Ann");
  public final static IElementType App = new FregeElementType("App");
  public final static IElementType Case = new FregeElementType("Case");
  public final static IElementType ClaDcl = new FregeElementType("ClaDcl");
  public final static IElementType ConFS = new FregeElementType("ConFS");
  public final static IElementType Con = new FregeElementType("Con");
  public final static IElementType DatDcl = new FregeElementType("DatDcl");
  public final static IElementType DocDcl = new FregeElementType("DocDcl");
  public final static IElementType DrvDcl = new FregeElementType("DrvDcl");
  public final static IElementType FixDecl = new FregeElementType("FixDecl");
  public final static IElementType FunDcl = new FregeElementType("FunDcl");
  public final static IElementType Ifte = new FregeElementType("Ifte");
  public final static IElementType ImpDcl = new FregeElementType("ImpDcl");
  public final static IElementType ImportItem = new FregeElementType("ImportItem");
  public final static IElementType ImportList = new FregeElementType("ImportList");
  public final static IElementType Infx = new FregeElementType("Infx");
  public final static IElementType InsDcl = new FregeElementType("InsDcl");
  public final static IElementType JavDcl = new FregeElementType("JavDcl");
  public final static IElementType Lam = new FregeElementType("Lam");
  public final static IElementType Let = new FregeElementType("Let");
  public final static IElementType Lit = new FregeElementType("Lit");
  public final static IElementType Mem = new FregeElementType("Mem");
  public final static IElementType ModDcl = new FregeElementType("ModDcl");
  public final static IElementType NatDcl = new FregeElementType("NatDcl");
  public final static IElementType Term = new FregeElementType("Term");
  public final static IElementType TypDcl = new FregeElementType("TypDcl");
  public final static IElementType Vbl = new FregeElementType("Vbl");
  public final static IElementType Simple = new FregeElementType("Simple");
  public final static IElementType With1 = new FregeElementType("With1");
  public final static IElementType With2 = new FregeElementType("With2");
  public final static IElementType Alts = new FregeElementType("Alts");
  public final static IElementType Alt = new FregeElementType("Alt");
  public final static IElementType Member = new FregeElementType("Member");
  public final static IElementType Pats = new FregeElementType("Pats");
  public final static IElementType Pat = new FregeElementType("Pat");

  public static PsiElement createElement(ASTNode node) {
    IElementType t = node.getElementType();
    if (t == AnnDcl) return new FregeAnnDclImpl(node);
    if (t == Ann) return new FregeAnnImpl(node);
    if (t == App) return new FregeAppImpl(node);
    if (t == Case) return new FregeCaseImpl(node);
    if (t == ClaDcl) return new FregeClaDclImpl(node);
    if (t == ConFS) return new FregeConFSImpl(node);
    if (t == Con) return new FregeConImpl(node);
    if (t == DatDcl) return new FregeDatDclImpl(node);
    if (t == DocDcl) return new FregeDocDclImpl(node);
    if (t == DrvDcl) return new FregeDrvDclImpl(node);
    if (t == FixDecl) return new FregeFixDeclImpl(node);
    if (t == FunDcl) return new FregeFunDclImpl(node);
    if (t == Ifte) return new FregeIfteImpl(node);
    if (t == ImpDcl) return new FregeImpDeclImpl(node);
    if (t == ImportItem) return new FregeImportItemImpl(node);
    if (t == ImportList) return new FregeImportListImpl(node);
    if (t == Infx) return new FregeInfxImpl(node);
    if (t == InsDcl) return new FregeInsDclImpl(node);
    if (t == JavDcl) return new FregeJavDclImpl(node);
    if (t == Let) return new FregeLetImpl(node);
    if (t == Lit) return new FregeLitImpl(node);
    if (t == Mem) return new FregeMemImpl(node);
    if (t == ModDcl) return new FregeModDclImpl(node);
    if (t == NatDcl) return new FregeNatDclImpl(node);
    if (t == Term) return new FregeTermImpl(node);
    if (t == TypDcl) return new FregeTypDclImpl(node);
    if (t == Vbl) return new FregeVblImpl(node);
    if (t == Simple) return new FregeSimpleImpl(node);
    if (t == With1) return new FregeWith1Impl(node);
    if (t == With2) return new FregeWith2Impl(node);
    if (t == Alts) return new FregeAltsImpl(node);
    if (t == Alt) return new FregeAltImpl(node);
    if (t == Member) return new FregeMemberImpl(node);
    if (t == Pats) return new FregePatsImpl(node);
    if (t == Pat) return new FregePatImpl(node);

    throw new RuntimeException("Unexpected IElementType: " + t);
  }
}

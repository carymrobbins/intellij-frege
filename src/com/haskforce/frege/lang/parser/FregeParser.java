package com.haskforce.frege.lang.parser;

import com.haskforce.frege.lang.lexer.FregeFlexParsingLexer;
import com.haskforce.frege.lang.lexer.FregeParsingLexer;
import com.haskforce.frege.lang.lexer.FregeTokenTypes;
import com.haskforce.frege.lang.psi.FregePsiTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.lang.impl.PsiBuilderAdapter;
import com.intellij.lang.impl.PsiBuilderImpl;
import com.intellij.psi.tree.IElementType;
import frege.compiler.common.Desugar.TProgram;
import frege.compiler.types.Positions;
import frege.compiler.types.SNames;
import frege.compiler.types.SourceDefinitions;
import frege.compiler.types.SourceDefinitions.TDefinitionS;
import frege.compiler.types.SourceDefinitions.TExprS;
import frege.compiler.types.Tokens;
import frege.prelude.PreludeBase;
import frege.prelude.PreludeBase.TList;
import frege.run8.Lazy;
import org.jetbrains.annotations.NotNull;

/** Parser which wraps Frege's internal parser and converts it into a Psi tree. */
public class FregeParser implements PsiParser {

  @NotNull
  @Override
  public ASTNode parse(@NotNull IElementType root, @NotNull PsiBuilder b) {
    Builder builder = new Builder(b);
    PreludeBase.TMaybe.DJust<TProgram> parseResult = getParseResult(builder).asJust();
    if (parseResult == null) {
      System.err.println("Failed to parse");
      return dummyParse(root, builder);
    }
    return new ProgramParser(builder, root).parse(parseResult.mem1.call());
  }

  private ASTNode dummyParse(@NotNull IElementType root, @NotNull Builder builder) {
    Marker marker = builder.mark();
    while (!builder.eof()) {
      builder.advanceLexer();
    }
    marker.done(root);
    return builder.getTreeBuilt();
  }

  private PreludeBase.TMaybe<TProgram> getParseResult(Builder builder) {
    return PreludeBase.TST.performUnsafe(FregeInternalParser.parse(builder.getFlex().getLexerTokens())).call();
  }

  public static class Builder extends PsiBuilderAdapter {
    public Builder(PsiBuilder builder) {
      super(builder);
    }

    public FregeFlexParsingLexer getFlex() {
      return ((FregeParsingLexer)((PsiBuilderImpl)myDelegate).getLexer()).getFlex();
    }
  }

  public static class ProgramParser {

    private final Builder builder;
    private final IElementType root;

    public ProgramParser(Builder builder, IElementType root) {
      this.builder = builder;
      this.root = root;
    }

    public ASTNode parse(TProgram p) {
      Marker m = builder.mark();
      program(p);
      trailingRBrace();
      m.done(root);
      return builder.getTreeBuilt();
    }

    private void program(TProgram p) {
      TProgram.DModule mod = p.asModule();
      if (mod == null) throw new ParseException("Expected module");
      Marker m = builder.mark();
      definitions(mod.mem1.call().mem2.call());
      m.done(FregePsiTypes.ModDcl);
    }

    private void trailingRBrace() {
      if (builder.getTokenType() == FregeTokenTypes.SYNTHETIC_RBRACE) {
        builder.advanceLexer();
      }
    }

    private void definitions(TList<TDefinitionS> defs) {
      TList.DCons<TDefinitionS> cons = defs.asCons();
      while (cons != null) {
        definition(cons.mem1.call());
        cons = cons.mem2.call().asCons();
      }
    }

    private void definition(TDefinitionS d) {
      if (d.asAnnDcl() != null) { annDcl(d.asAnnDcl()); return; }
      if (d.asClaDcl() != null) { claDcl(d.asClaDcl()); return; }
      if (d.asDatDcl() != null) { datDcl(d.asDatDcl()); return; }
      if (d.asDocDcl() != null) { docDcl(d.asDocDcl()); return; }
      if (d.asDrvDcl() != null) { drvDcl(d.asDrvDcl()); return; }
      if (d.asFunDcl() != null) { funDcl(d.asFunDcl()); return; }
      if (d.asImpDcl() != null) { impDcl(d.asImpDcl()); return; }
      if (d.asInsDcl() != null) { insDcl(d.asInsDcl()); return; }
      if (d.asJavDcl() != null) { javDcl(d.asJavDcl()); return; }
      if (d.asModDcl() != null) { modDcl(d.asModDcl()); return; }
      if (d.asNatDcl() != null) { natDcl(d.asNatDcl()); return; }
      if (d.asTypDcl() != null) { typDcl(d.asTypDcl()); return; }
      throw new ParseException("Unexpected DefinitionS: " + d);
    }

    private void consumeUntilOffset(Lazy<Positions.TPosition> pos, IElementType typ) {
      consumeUntilOffset(pos.call().mem$last.mem$offset, typ);
    }

    private void consumeUntilOffset(int lastOffset, IElementType typ) {
      Marker m = builder.mark();
      while (builder.getCurrentOffset() <= lastOffset) {
        builder.advanceLexer();
      }
      m.done(typ);
    }

    private void annDcl(TDefinitionS.DAnnDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.AnnDcl);
    }

    private void claDcl(TDefinitionS.DClaDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.ClaDcl);
    }

    private void datDcl(TDefinitionS.DDatDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.DatDcl);
    }

    private void docDcl(TDefinitionS.DDocDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.DocDcl);
    }

    private void drvDcl(TDefinitionS.DDrvDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.DrvDcl);
    }

    private void impDcl(TDefinitionS.DImpDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.ImpDcl);
    }

    private void insDcl(TDefinitionS.DInsDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.InsDcl);
    }

    private void javDcl(TDefinitionS.DJavDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.JavDcl);
    }

    private void modDcl(TDefinitionS.DModDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.ModDcl);
    }
    private void natDcl(TDefinitionS.DNatDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.NatDcl);
    }

    private void typDcl(TDefinitionS.DTypDcl d) {
      consumeUntilOffset(d.mem$pos, FregePsiTypes.TypDcl);
    }

    private void funDcl(TDefinitionS.DFunDcl d) {
      Marker m = builder.mark();
      expr(d.mem$lhs.call());
      pats(d.mem$pats.call());
      expr(d.mem$expr.call());
      m.done(FregePsiTypes.FunDcl);
    }

    private void pats(TList<TExprS> es) {
      Marker m = builder.mark();
      TList.DCons<TExprS> cons = es.asCons();
      while (cons != null) {
        pat(cons.mem1.call());
        cons = cons.mem2.call().asCons();
      }
      m.done(FregePsiTypes.Pats);
    }

    private void pat(TExprS e) {
      Marker m = builder.mark();
      expr(e);
      m.done(FregePsiTypes.Pat);
    }

    private void expr(TExprS e) {
      if (e.asAnn() != null) { ann(e.asAnn()); return; }
      if (e.asApp() != null) { app(e.asApp()); return; }
      if (e.asCase() != null) { case_(e.asCase()); return; }
      if (e.asConFS() != null) { conFS(e.asConFS()); return; }
      if (e.asCon() != null) { con(e.asCon()); return; }
      if (e.asIfte() != null) { ifte(e.asIfte()); return; }
      if (e.asInfx() != null) { infx(e.asInfx()); return; }
      if (e.asLam() != null) { lam(e.asLam()); return; }
      if (e.asLet() != null) { let(e.asLet()); return; }
      if (e.asLit() != null) { lit(e.asLit()); return; }
      if (e.asMem() != null) { mem(e.asMem()); return; }
      if (e.asTerm() != null) { term(e.asTerm()); return; }
      if (e.asVbl() != null) { vbl(e.asVbl()); return; }
      throw new ParseException("Unexpected ExprS: " + e);
    }

    private void ann(TExprS.DAnn e) {
      throw new ParseException("Ann not implemented");
    }

    private void app(TExprS.DApp e) {
      Marker m = builder.mark();
      expr(e.mem$fun);
      expr(e.mem$arg);
      m.done(FregePsiTypes.App);
    }

    private void case_(TExprS.DCase e) {
      Marker m = builder.mark();
      expr(e.mem$ex);
      alts(e.mem$alts);
      m.done(FregePsiTypes.Case);
    }

    private void alts(TList<SourceDefinitions.TCAltS> es) {
      Marker m = builder.mark();
      TList.DCons<SourceDefinitions.TCAltS> cons = es.asCons();
      while (cons != null) {
        alt(cons.mem1.call());
        cons = cons.mem2.call().asCons();
      }
      m.done(FregePsiTypes.Alts);
    }

    private void alt(SourceDefinitions.TCAltS e) {
      Marker m = builder.mark();
      expr(e.mem$pat);
      expr(e.mem$ex);
      m.done(FregePsiTypes.Alt);
    }

    private void conFS(TExprS.DConFS e) {
      throw new ParseException("ConFS not implemented");
    }

    private void con(TExprS.DCon e) {
      Marker m = builder.mark();
      sName(e.mem$name);
      m.done(FregePsiTypes.Con);
    }

    private void ifte(TExprS.DIfte e) {
      Marker m = builder.mark();
      consumeTokenText("if", "ifte");
      expr(e.mem$cnd);
      consumeTokenText("then", "ifte");
      expr(e.mem$thn);
      consumeTokenText("else", "ifte");
      expr(e.mem$els);
      m.done(FregePsiTypes.Ifte);
    }

    private void infx(TExprS.DInfx e) {
      Marker m = builder.mark();
      expr(e.mem$left);
      sName(e.mem$name);
      expr(e.mem$right);
      m.done(FregePsiTypes.Infx);
    }

    private void lam(TExprS.DLam e) {
      Marker m = builder.mark();
      consumeTokenText("\\", "lam");
      expr(e.mem$pat);
      consumeTokenText("->", "lam");
      expr(e.mem$ex);
      m.done(FregePsiTypes.Lam);
    }

    private void let(TExprS.DLet e) {
      Marker m = builder.mark();
      definitions(e.mem$defs);
      expr(e.mem$ex);
      m.done(FregePsiTypes.Let);
    }

    private void lit(TExprS.DLit e) {
      consumeUntilOffset(e.mem$pos.mem$last.mem$offset, FregePsiTypes.Lit);
    }

    private void mem(TExprS.DMem e) {
      Marker m = builder.mark();
      expr(e.mem$ex);
      member(e.mem$member);
      m.done(FregePsiTypes.Mem);
    }

    private void member(Tokens.TToken tok) {
      Marker m = builder.mark();
      assertTokenText(".", "member");
      builder.advanceLexer();
      assertTokenText(tok.mem$value, "member");
      builder.advanceLexer();
      m.done(FregePsiTypes.Member);
    }

    private void term(TExprS.DTerm e) {
      Marker m = builder.mark();
      expr(e.mem$ex);
      m.done(FregePsiTypes.Term);
    }

    private void vbl(TExprS.DVbl e) {
      Marker m = builder.mark();
      sName(e.mem$name);
      m.done(FregePsiTypes.Vbl);
    }

    private void sName(SNames.TSName e) {
      if (e.asSimple() != null) { simple(e.asSimple()); return; }
      if (e.asWith1() != null) { with1(e.asWith1()); return; }
      if (e.asWith2() != null) { with2(e.asWith2()); return; }
      throw new ParseException("Unexpected SName: " + e);
    }

    private void simple(SNames.TSName.DSimple e) {
      consumeUntilOffset(e.mem$id.mem$offset, FregePsiTypes.Simple);
    }

    private void with1(SNames.TSName.DWith1 e) {
      consumeUntilOffset(e.mem$id.mem$offset, FregePsiTypes.With1);
    }

    private void with2(SNames.TSName.DWith2 e) {
      consumeUntilOffset(e.mem$id.mem$offset, FregePsiTypes.With2);
    }

    private void maybeConsumeTokenText(@NotNull String expected) {
      String actual = builder.getTokenText();
      while (actual != null && actual.trim().isEmpty()) {
        builder.advanceLexer();
        actual = builder.getTokenText();
      }
      if (expected.equals(builder.getTokenText())) {
        builder.advanceLexer();
      }
    }

    private void consumeTokenText(@NotNull String expected, @NotNull String descr) {
      String actual = builder.getTokenText();
      while (actual != null && actual.trim().isEmpty()) {
        builder.advanceLexer();
        actual = builder.getTokenText();
      }
      assertTokenText(expected, descr);
      builder.advanceLexer();
    }

    private void assertTokenText(@NotNull String expected, @NotNull String descr) {
      String actual = builder.getTokenText();
      if (expected.equals(actual)) return;
      throw new ParseException(
        "Expected '" + expected + "' but got '" + actual + "'\n"
          + "Offset: " + builder.getCurrentOffset() + "\n"
          + "Description: " + descr
      );
    }

    public class ParseException extends RuntimeException {
      public ParseException(String message) {
        super(message);
      }
    }
  }
}

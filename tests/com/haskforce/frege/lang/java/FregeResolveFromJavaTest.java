package com.haskforce.frege.lang.java;

import com.haskforce.ResolveReferenceTestBase;

public class FregeResolveFromJavaTest extends ResolveReferenceTestBase {
  public FregeResolveFromJavaTest() {
    super("frege/resolve/java");
  }

  public void testMethod00001() { doTest(); }
  public void testModule00001() { doTest(); }
  public void testModule00002() { doTest(); }
  public void testModule00003() { doTest(); }
}

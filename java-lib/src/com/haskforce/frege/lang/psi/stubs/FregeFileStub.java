package com.haskforce.frege.lang.psi.stubs;

import com.haskforce.frege.lang.psi.FregeFile;
import com.intellij.psi.stubs.PsiFileStubImpl;

public class FregeFileStub extends PsiFileStubImpl<FregeFile> {
  public FregeFileStub(FregeFile file) {
    super(file);
  }
}

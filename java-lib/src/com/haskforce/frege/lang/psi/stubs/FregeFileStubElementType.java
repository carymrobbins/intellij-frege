package com.haskforce.frege.lang.psi.stubs;

import com.haskforce.frege.lang.FregeLanguage;
import com.haskforce.frege.lang.psi.FregeFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.StubBuilder;
import com.intellij.psi.stubs.DefaultStubBuilder;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.psi.tree.IStubFileElementType;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class FregeFileStubElementType extends IStubFileElementType<FregeFileStub> {

  public static final int VERSION = 0;
  public static final IStubFileElementType INSTANCE = new FregeFileStubElementType();

  public FregeFileStubElementType() {
    super("FILE", FregeLanguage.INSTANCE);
  }

  @Override
  public StubBuilder getBuilder() {
    return new DefaultStubBuilder() {
      @NotNull
      @Override
      protected StubElement createStubForFile(@NotNull PsiFile file) {
        if (file instanceof FregeFile) return new FregeFileStub((FregeFile)file);
        return super.createStubForFile(file);
      }
    };
  }

  @Override
  public int getStubVersion() {
    return VERSION;
  }

  @Override
  public void serialize(@NotNull FregeFileStub stub, @NotNull StubOutputStream dataStream) throws IOException {
    // noop
  }

  @NotNull
  @Override
  public FregeFileStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
    return new FregeFileStub(null);
  }

  @NotNull
  @Override
  public String getExternalId() {
    return "frege.FILE";
  }
}

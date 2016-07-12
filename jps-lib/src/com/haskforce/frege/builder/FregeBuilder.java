package com.haskforce.frege.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.incremental.*;

import java.io.IOException;

public class FregeBuilder extends ModuleLevelBuilder {

  protected FregeBuilder() {
    super(BuilderCategory.TRANSLATOR);
  }

  @NotNull
  @Override
  public String getPresentableName() {
    return "Frege builder";
  }

  @Override
  public ExitCode build(
    CompileContext context, ModuleChunk chunk,
    DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder,
    OutputConsumer outputConsumer
  ) throws ProjectBuildException, IOException {

    return null;
  }
}

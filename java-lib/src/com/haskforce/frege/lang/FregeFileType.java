package com.haskforce.frege.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/** Specifies a file as a Frege file. */
public class FregeFileType extends LanguageFileType {
  public static final FregeFileType INSTANCE = new FregeFileType();

  private FregeFileType() {
    super(FregeLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "Frege";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Frege language file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "fr";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return FregeIcons.FILE;
  }
}

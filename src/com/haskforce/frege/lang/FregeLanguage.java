package com.haskforce.frege.lang;

import com.intellij.lang.Language;

/**
 * Provides a way for components to be registered for Frege language support.
 *
 * If you need an instance of this class, use the INSTANCE static member.
 */
public class FregeLanguage extends Language {
  public static final FregeLanguage INSTANCE = new FregeLanguage();

  protected FregeLanguage() {
    super("Frege");
  }

  @Override
  public boolean isCaseSensitive() {
    return true;
  }
}

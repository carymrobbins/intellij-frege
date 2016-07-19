package com.haskforce.frege.lang.psi.impl;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ItemPresentationFactory {
  public static ItemPresentation create(@Nullable String text, @Nullable String location,
                                        @Nullable Icon icon) {
    return new ItemPresentation() {
      @Nullable
      @Override
      public String getPresentableText() {
        return text;
      }

      @Nullable
      @Override
      public String getLocationString() {
        return location;
      }

      @Nullable
      @Override
      public Icon getIcon(boolean unused) {
        return icon;
      }
    };
  }
}

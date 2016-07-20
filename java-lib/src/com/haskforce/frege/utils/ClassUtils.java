package com.haskforce.frege.utils;

import org.jetbrains.annotations.NotNull;

public abstract class ClassUtils {

  public static String getPackageName(@NotNull String fqn) {
    int pos = fqn.lastIndexOf('.');
    if (pos == -1) return "";
    return fqn.substring(0, pos);
  }

  public static String getClassName(@NotNull String fqn) {
    int pos = fqn.lastIndexOf('.');
    if (pos == -1) return "";
    return fqn.substring(pos + 1);
  }
}

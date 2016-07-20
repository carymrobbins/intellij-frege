package com.haskforce.frege.utils;

public abstract class ClassUtils {

  public static String getPackageName(String fqn) {
    int pos = fqn.lastIndexOf('.');
    if (pos == -1) return "";
    return fqn.substring(0, pos);
  }
}

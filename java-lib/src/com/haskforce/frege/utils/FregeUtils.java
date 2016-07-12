package com.haskforce.frege.utils;

public abstract class FregeUtils {

  /** Safely check object equality, avoiding NullPointerException. */
  public static <A, B> boolean objEquals(A a, B b) {
    return a == null && b == null || a != null && b != null && a.equals(b);
  }
}

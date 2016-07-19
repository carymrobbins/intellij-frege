package foo;

import baz.Quux;

public class Bar {
  void f() {
    // Resolve imported reference.
    System.out.println(<ref>Quux.class);
  }
}

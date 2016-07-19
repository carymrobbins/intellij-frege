package foo;

public class Bar {
  void f() {
    // Resolve reference from local package.
    System.out.println(<ref>Quux.class);
  }
}

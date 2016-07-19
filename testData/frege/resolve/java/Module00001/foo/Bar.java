package foo;

public class Bar {
  void f() {
    // Resolve qualified reference.
    System.out.println(baz.<ref>Quux.class);
  }
}

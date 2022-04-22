class Child extends Parent {
  int num = 5;

  protected void foo() {
	System.out.println("foo() of Child");
  }

  static protected void bar() {
	System.out.println("bar() of Child");
  }
}
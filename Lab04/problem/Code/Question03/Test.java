public class Test {
  public static void main(String[] args) {
	Parent f1 = new Parent();
	System.out.println(f1.num);

	Parent f2 = new Child();
	System.out.println(f2.num);

	Child c = new Child();
	System.out.println(c.num);

	f1.foo();
	f2.foo();
	c.foo();

	f1.bar();
	f2.bar();
	c.bar();
  }
}
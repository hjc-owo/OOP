interface Inter {
  void show();
}

class Outer {
  /*???*/
}

public class Test {
  public static void main(String[] args) {
	Outer.method().show();
  }
}

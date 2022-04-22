package a;

public class Child extends Parent {
    private void cm1() {
        System.out.println("in cm1()");
    }

    void cm2() {
        System.out.println("in cm2()");
    }

    protected void cm3() {
        System.out.println("in cm3()");
    }

    public void cm4() {
        System.out.println("in cm4()");
    }

    public static void main(String[] args) {
        Child c = new Child();
        c.cm1();
        c.cm2();
        c.cm3();
        c.cm4();
//        c.fm1();
        c.fm2();
        c.fm3();
        c.fm4();
    }
}

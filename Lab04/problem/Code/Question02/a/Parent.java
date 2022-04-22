package a;

public class Parent {
    private int f1 = 11;
    int f2 = 12;
    protected int f3 = 13;
    public int f4 = 14;

    private void fm1() {
        System.out.println("in fm1()");
    }

    void fm2() {
        System.out.println("in fm2()");
    }

    protected void fm3() {
        System.out.println("in fm3()");
    }

    public void fm4() {
        System.out.println("in fm4()");
    }

    public static void main(String[] args) {
        Parent p = new Parent();
        p.fm1();
        p.fm2();
        p.fm3();
        p.fm4();
    }
}

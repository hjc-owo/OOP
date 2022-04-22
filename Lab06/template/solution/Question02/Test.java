interface Inter {
    void show();
}

class Outer {
    static class Inner implements Inter {
        public Inner() {
        }

        @Override
        public void show() {
            System.out.println("DuluDulu");
        }
    }

    public static Inner method() {
        return new Outer.Inner();
    }
}

public class Test {
    public static void main(String[] args) {
        Outer.method().show();
    }
}



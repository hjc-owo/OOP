public class Test {
    public static void main(String[] args) {

        ShapeSequence a = new ShapeSequence(6);
        a.add(new Rectangle(12, 12));
        a.add(new Rhombus(12, 12));
        a.add(new Ellipse(12, 12));
        a.add(new Rectangle(10, 10));
        a.add(new Rhombus(10, 10));
        a.add(new Ellipse(10, 10));
        System.out.println(a);

        ShapeSequence.Iterator it = a.iterator();
        System.out.println("current? " + it.current());

        it.moveNext();
        it.moveNext();
        it.moveNext();
        it.moveNext();
        it.moveNext();
        it.moveNext();
        System.out.println("isEnd? " + it.isEnd());

        ShapeSequence.Iterator it2 = a.iterator();
        System.out.println("equals? " + it.equals(it2));

        it2.moveNext();
        it2.moveNext();
        it2.moveNext();
        it2.moveNext();
        it2.moveNext();
        it2.moveNext();
        System.out.println("equals? " + it.equals(it2));

        System.out.println("isEnd? " + it2.isEnd());


    }
}

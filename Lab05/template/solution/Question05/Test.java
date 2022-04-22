import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        Rectangle rectangle = new Rectangle(a, b);
        Rhombus rhombus = new Rhombus(a, b);
        Ellipse ellipse = new Ellipse(a, b);
        System.out.println("rectangle: " + rectangle.calcArea());
        System.out.println("rhombus: " + rhombus.calcArea());
        System.out.println("ellipse: " + ellipse.calcArea());

        Shape[] arr = new Shape[3];
        ShapeFactory shapeFactory = new ShapeFactory();

        System.out.println("make a shape");
        arr[0] = shapeFactory.makeShape(ShapeFactory.ShapeType.Rectangle, a, b);
        System.out.println("rectangle: " + arr[0].calcArea());
        arr[1] = shapeFactory.makeShape(ShapeFactory.ShapeType.Rhombus, a, b);
        System.out.println("rhombus: " + arr[1].calcArea());
        arr[2] = shapeFactory.makeShape(ShapeFactory.ShapeType.Ellipse, a, b);
        System.out.println("ellipse: " + arr[2].calcArea());

        System.out.println("make random shape");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = shapeFactory.randomNextShape();
        }
        for (Shape shape : arr) {
            System.out.println(shape.toString() + " " + shape.calcArea());
        }


    }
}

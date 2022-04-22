import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeFactoriesTest {
    static Shape makeShape(IShapeFactory factory, double a, double b) {
        return factory.makeShape(a, b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        List<IShapeFactory> factories = new ArrayList<>();
        factories.add(new RectangleFactory());
        factories.add(new RhombusFactory());
        factories.add(new EllipseFactory());
        for (IShapeFactory factory : factories) {
            Shape shape = makeShape(factory, a, b);
            System.out.println(shape.getClass().getName() + ": " + shape.calcArea());
        }
    }
}

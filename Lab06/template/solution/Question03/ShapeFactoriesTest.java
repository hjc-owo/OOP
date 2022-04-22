import java.util.Scanner;

public class ShapeFactoriesTest {
    static Shape makeShape(IShapeFactory factory, double a, double b) {
        return factory.makeShape(a, b);
    }

    /* 测试调用的工厂是否是单例：
     * 每个工厂重复调用两次，存入数组中，然后输出其地址。
     * 若发现两次调用地址相同，则是单例。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        IShapeFactory[] factories = {
                RectangleFactory.getFactory(),
                RhombusFactory.getFactory(),
                EllipseFactory.getFactory(),
                RectangleFactory.getFactory(),
                RhombusFactory.getFactory(),
                EllipseFactory.getFactory(),
        };

        for (IShapeFactory factory : factories) {
            System.out.println(factory);
            Shape shape = makeShape(factory, a, b);
            System.out.println(shape.getClass().getName() + ": " + shape.calcArea());
        }
    }
}

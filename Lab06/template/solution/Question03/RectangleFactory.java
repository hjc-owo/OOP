public class RectangleFactory implements IShapeFactory {

    private static final RectangleFactory factory = new RectangleFactory();

    private RectangleFactory() {
    }

    public static RectangleFactory getFactory() {
        return factory;
    }

    @Override
    public Shape makeShape(double a, double b) {
        if (a < 0 || b < 0) {
            return null;
        }
        return new Rectangle(a, b);
    }
}

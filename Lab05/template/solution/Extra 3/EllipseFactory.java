public class EllipseFactory implements IShapeFactory {

    private static final EllipseFactory factory = new EllipseFactory();

    private EllipseFactory() {
    }

    public static EllipseFactory getFactory() {
        return factory;
    }

    @Override
    public Shape makeShape(double a, double b) {
        if (a < 0 || b < 0) {
            return null;
        }
        return new Ellipse(a, b);
    }
}

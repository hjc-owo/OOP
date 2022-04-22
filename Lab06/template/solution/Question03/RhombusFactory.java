public class RhombusFactory implements IShapeFactory {
    private static final RhombusFactory factory = new RhombusFactory();

    private RhombusFactory() {
    }

    public static RhombusFactory getFactory() {
        return factory;
    }

    @Override
    public Shape makeShape(double a, double b) {
        if (a < 0 || b < 0) {
            return null;
        }
        return new Rhombus(a, b);
    }
}
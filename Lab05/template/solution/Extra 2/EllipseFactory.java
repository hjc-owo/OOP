public class EllipseFactory implements IShapeFactory {
    @Override
    public Shape makeShape(double a, double b) {
        if (a < 0 || b < 0) {
            return null;
        }
        return new Ellipse(a, b);
    }
}

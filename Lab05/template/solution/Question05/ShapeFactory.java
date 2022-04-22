public class ShapeFactory {
    enum ShapeType {
        Rectangle, Ellipse, Rhombus
    }

    public Shape makeShape(ShapeType type, double a, double b) {
        if (a < 0 || b < 0) {
            return null;
        }
        return switch (type) {
            case Rectangle -> new Rectangle(a, b);
            case Ellipse -> new Ellipse(a, b);
            case Rhombus -> new Rhombus(a, b);
        };
    }

    public Shape randomNextShape() {
        int x = (int) (Math.random() * 1000 % 3);
        return switch (x) {
            case 0 -> new Rectangle(Math.random() * 100, Math.random() * 100);
            case 1 -> new Rhombus(Math.random() * 100, Math.random() * 100);
            case 2 -> new Ellipse(Math.random() * 100, Math.random() * 100);
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };
    }
}

public class Rectangle extends Shape {

    public Rectangle() {
        super();
    }

    public Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double calcArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}

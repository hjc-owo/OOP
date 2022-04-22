import static java.lang.Math.PI;

public class Ellipse extends Shape {
    public Ellipse() {
        super();
    }

    public Ellipse(double a, double b) {
        super(a, b);
    }

    @Override
    public double calcArea() {
        return PI * a * b;
    }

    @Override
    public String toString() {
        return "Ellipse";
    }
}

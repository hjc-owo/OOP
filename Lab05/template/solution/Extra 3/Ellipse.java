import static java.lang.Math.PI;

public class Ellipse extends Shape {

    public Ellipse(double a, double b) {
        if (a < 0) a = 0;
        if (b < 0) b = 0;
        this.a = a;
        this.b = b;
    }

    public Ellipse() {
        this(0, 0);
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

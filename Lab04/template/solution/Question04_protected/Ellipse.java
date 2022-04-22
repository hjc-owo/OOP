import static java.lang.Math.PI;

public class Ellipse extends Shape {
    @Override
    public double calcArea() {
        return PI * a * b;
    }
}

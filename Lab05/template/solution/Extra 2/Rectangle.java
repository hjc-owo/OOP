public class Rectangle extends Shape {

    public Rectangle() {
        this(0,0);
    }

    public Rectangle(double a, double b) {
        if (a < 0) a = 0;
        if (b < 0) b = 0;
        this.a = a;
        this.b = b;
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

public class Rhombus extends Shape {

    public Rhombus(double a, double b) {
        if (a < 0) a = 0;
        if (b < 0) b = 0;
        this.a = a;
        this.b = b;
    }

    public Rhombus() {
        this(0, 0);
    }

    @Override
    public double calcArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Rhombus";
    }
}

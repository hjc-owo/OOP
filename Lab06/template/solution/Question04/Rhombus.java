public class Rhombus extends Shape {

    public Rhombus() {
        super();
    }

    public Rhombus(double a, double b) {
        super(a, b);
    }

    @Override
    public double calcArea() {
        return a * b / 2;
    }

    @Override
    public String toString() {
        return "Rhombus";
    }
}

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        Rectangle rectangle = new Rectangle();
        rectangle.setA(a);
        rectangle.setB(b);
        Rhombus rhombus = new Rhombus();
        rhombus.setA(a);
        rhombus.setB(b);
        Ellipse ellipse = new Ellipse();
        ellipse.setA(a);
        ellipse.setB(b);
        System.out.println(rectangle.calcArea());
        System.out.println(rhombus.calcArea());
        System.out.println(ellipse.calcArea());
    }
}

class Triangle {
    double x, y, z;

    public Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void checkWhetherTriangle() throws NotTriangleException {
        if (x + y <= z || x + z <= y || y + z <= x) {
            throw new NotTriangleException(x, y, z);
        }
    }

    public double getArea() throws NotTriangleException {
        checkWhetherTriangle();
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    public void showInfo() throws NotTriangleException {
        checkWhetherTriangle();
        System.out.println("x = " + this.x);
        System.out.println("y = " + this.y);
        System.out.println("z = " + this.z);
    }
}

public class Triangle_Test {
    public static void main(String[] args) throws NotTriangleException {
        Triangle t1 = new Triangle(3, 4, 5);
        System.out.println(t1.getArea());
        t1.showInfo();

        Triangle t2 = new Triangle(2, 4, 6);
        System.out.println(t2.getArea());
        t2.showInfo();
    }
}

class NotTriangleException extends Exception {
    public NotTriangleException(double x, double y, double z) {
        super(x + " " + y + " " + z + " 这似乎好像不能组成一个三角形捏～");
    }
}

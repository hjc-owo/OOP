import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("19241027 胡峻诚\n");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        while (!str.equals("QUIT")) {
            System.out.println("Hello World!");
            str = input.next();
        }
        System.out.println("----- Good Bye! -----");
        System.exit(0);
    }
}

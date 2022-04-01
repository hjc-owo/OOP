import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String argStr;
        while (true) {
            argStr = in.nextLine();
            if (Objects.equals(argStr, "QUIT")) {
                System.out.println("----- Good Bye! -----");
                System.exit(0);
            }

            String[] op = argStr.split(" ");
            if (Objects.equals(op[0], "addUser")) {
                User user = new User();
                user.addUser(argStr);
            }
        }
    }
}


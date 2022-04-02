import java.util.Objects;
import java.util.Scanner;

public class Test {

    static boolean changeIdentity(String argStr, boolean isSuperAdmins) {
        if (Objects.equals(argStr, "TunakTunakTun")) {
            if (!isSuperAdmins) {
                System.out.println("DuluDulu");
                return true;
            } else {
                System.out.println("WanNiBa");
                return false;
            }
        } else if (Objects.equals(argStr, "NutKanutKanut")) {
            if (isSuperAdmins) {
                System.out.println("DaDaDa");
                return true;
            } else {
                System.out.println("WanNiBa");
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String argStr;
        boolean isSuperAdmins = false;

        while (true) {
            argStr = in.nextLine();
            if (Objects.equals(argStr, "QUIT")) {
                System.out.println("----- Good Bye! -----");
                System.exit(0);
            } else if (changeIdentity(argStr, isSuperAdmins)) {
                isSuperAdmins = !isSuperAdmins;
            }


            String[] op = argStr.split(" ");
            if (Objects.equals(op[0], "addUser")) {
                User user = new User();
                System.out.println(user.addUser(op));
            } else if (Objects.equals(op[0], "addLine")) {
                SuperAdmin superAdmin = new SuperAdmin();
                System.out.println(superAdmin.addLine(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "delLine")) {
                SuperAdmin superAdmin = new SuperAdmin();
                System.out.println(superAdmin.delLine(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "addStation")) {
                SuperAdmin superAdmin = new SuperAdmin();
                System.out.println(superAdmin.addStation(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "delStation")) {
                SuperAdmin superAdmin = new SuperAdmin();
                System.out.println(superAdmin.delStation(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "lineInfo")) {
                User user = new User();
                System.out.println(user.lineInfo(op));
            } else if (Objects.equals(op[0], "listLine")) {
                User user = new User();
                System.out.println(user.listLine(op));
            } else if (Objects.equals(op[0], "addTrain")) {
                SuperAdmin superAdmin = new SuperAdmin();
                System.out.println(superAdmin.addTrain(op, isSuperAdmins));
            }
        }
    }
}


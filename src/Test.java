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
                user.addUser(op);
            } else if (Objects.equals(op[0], "addLine")) {
                if (isSuperAdmins) {
                    SuperAdmin superAdmin = new SuperAdmin();
                    superAdmin.addLine(op);
                } else {
                    System.out.println("Command does not exist");
                }
            } else if (Objects.equals(op[0], "delLine")) {
                if (isSuperAdmins) {
                    SuperAdmin superAdmin = new SuperAdmin();
                    superAdmin.delLine(op);
                } else {
                    System.out.println("Command does not exist");
                }
            } else if (Objects.equals(op[0], "addStation")) {
                if (isSuperAdmins) {
                    SuperAdmin superAdmin = new SuperAdmin();
                    superAdmin.addStation(op);
                } else {
                    System.out.println("Command does not exist");
                }
            } else if (Objects.equals(op[0], "delStation")) {
                if (isSuperAdmins) {
                    SuperAdmin superAdmin = new SuperAdmin();
                    superAdmin.delStation(op);
                } else {
                    System.out.println("Command does not exist");
                }
            } else if (Objects.equals(op[0], "lineInfo")) {
                User user = new User();
                user.lineInfo(op);
            } else if (Objects.equals(op[0], "listLine")) {
                User user = new User();
                user.listLine(op);
            }
        }
    }
}


import java.util.ArrayList;
import java.util.List;
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

    static List<String> commands = new ArrayList<>(List.of("QUIT",
            "TunakTunakTun",
            "NutKanutKanut",
            "addUser",
            "addLine",
            "delLine",
            "addStation",
            "delStation",
            "lineInfo",
            "listLine",
            "addTrain",
            "delTrain",
            "checkTicket",
            "listTrain",
            "login",
            "logout",
            "buyTicket",
            "listOrder"
    ));


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String argStr;
        boolean isSuperAdmins = false;
        Train.init();

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
                System.out.println(User.addUser(op));
            } else if (Objects.equals(op[0], "addLine")) {
                System.out.println(SuperAdmin.addLine(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "delLine")) {
                System.out.println(SuperAdmin.delLine(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "addStation")) {
                System.out.println(SuperAdmin.addStation(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "delStation")) {
                System.out.println(SuperAdmin.delStation(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "lineInfo")) {
                System.out.println(User.lineInfo(op));
            } else if (Objects.equals(op[0], "listLine")) {
                System.out.println(User.listLine(op));
            } else if (Objects.equals(op[0], "addTrain")) {
                System.out.println(SuperAdmin.addTrain(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "delTrain")) {
                System.out.println(SuperAdmin.delTrain(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "checkTicket")) {
                System.out.println(NormalUser.checkTicket(op, isSuperAdmins));
            } else if (Objects.equals(op[0], "listTrain")) {
                System.out.println(User.listTrain(op));
            } else if (Objects.equals(op[0], "login")) {
                System.out.println(User.login(op));
            } else if (Objects.equals(op[0], "logout")) {
                System.out.println(User.logout(op));
            } else if (Objects.equals(op[0], "buyTicket")) {
                System.out.println(User.buyTicket(op));
            } else if (Objects.equals(op[0], "listOrder")) {
                System.out.println(User.listOrder(op));
            }
        }
    }
}


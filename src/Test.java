import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

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

class User {
    String name;
    String sex;
    String Aadhaar;

    public static List<User> alreadyExisted = new ArrayList<>();

    public User(){}

    public User(String name, String sex, String Aadhaar) {
        this.name = name;
        this.sex = sex;
        this.Aadhaar = Aadhaar;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    void setAadhaar(String Aadhaar) {
        this.Aadhaar = Aadhaar;
    }

    String getAadhaar() {
        return this.Aadhaar;
    }

    @Override
    public String toString() {
        System.out.println("Name:" + this.name);
        System.out.println("Sex:" + this.sex);
        System.out.println("Aadhaar:" + this.Aadhaar);
        return null;
    }

    void addUser(String argStr) {
        String[] op = argStr.split(" ");

        if (op.length != 4) {
            System.out.println("Arguments illegal");
        } else {
            boolean Aadhaar_illegal = false;
            boolean Aadhaar_exists = false;

            if (!Pattern.matches("^[A-Za-z_]+$", op[1])) {
                System.out.println("Name illegal");
            } else if (!Pattern.matches("^[FMO]$", op[2])) {
                System.out.println("Sex illegal");
            } else {
                int end = Integer.parseInt(op[3].substring(11));
                if (!Pattern.matches("^(000[1-9]|00[1-9]\\d|0[1-9]\\d{2}|1[0-1]\\d{2}|12[0-2]\\d|123[0-7])(00[2-9]\\d|0[1-3]\\d{2}|04[0-5]\\d|0460)(0\\d{2}|100)([0-2])$", op[3])) {
                    Aadhaar_illegal = true;
                } else if ((end == 0 && !Objects.equals(op[2], "F") ||
                        end == 1 && !Objects.equals(op[2], "M")) ||
                        end == 2 && !Objects.equals(op[2], "O")) {
                    Aadhaar_illegal = true;
                }
                if (Aadhaar_illegal) {
                    System.out.println("Aadhaar number illegal");
                } else {
                    for (User u : alreadyExisted) {
                        if (Objects.equals(u.Aadhaar, op[3])) {
                            Aadhaar_exists = true;
                            break;
                        }
                    }
                    if (Aadhaar_exists) {
                        System.out.println("Aadhaar number exist");
                    } else {
                        this.name = op[1];
                        this.sex = op[2];
                        this.Aadhaar = op[3];
                        User user = new User(op[1], op[2], op[3]);
                        alreadyExisted.add(user);
                        this.toString();
                    }
                }
            }
        }
    }
}

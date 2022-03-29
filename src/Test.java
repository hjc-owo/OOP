import java.util.ArrayList;
import java.util.List;
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

class User {
    String name;
    String sex;
    String Aadhaar;

    public static List<String> alreadyExisted = new ArrayList<>();

//    public User(String name, String sex, String Aadhaar) {
//        this.name = name;
//        this.sex = sex;
//        this.Aadhaar = Aadhaar;
//    }

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
            boolean name_illegal = false;
            boolean Aadhaar_illegal = false;
            boolean Aadhaar_exists = false;

            Pattern pattern = Pattern.

            char[] ch1 = op[1].toCharArray();
            for (char c : ch1) {
                if ((c != '_') && !isalpha(c)) {
                    name_illegal = true;
                    break;
                }
            }
            if (!Pattern.matches("^[A-Za-z_]$", op[1])) {
                System.out.println("Name illegal");
            } else if ((!Objects.equals(op[2], "F") && !op[2].equals("M") && !op[2].equals("O"))) {
                System.out.println("Sex illegal");
            } else {
                char[] ch3 = op[3].toCharArray();
                for (char c : ch3) {
                    if (!isdigit(c)) {
                        Aadhaar_illegal = true;
                        break;
                    }
                }
                if (!Aadhaar_illegal) {
                    if (op[3].length() != 12) {
                        Aadhaar_illegal = true;
                    } else {
                        int first_4 = Integer.parseInt(op[3].substring(0, 4));
                        int middle_4 = Integer.parseInt(op[3].substring(4, 8));
                        int last_3 = Integer.parseInt(op[3].substring(8, 11));
                        int end = Integer.parseInt(op[3].substring(11));
                        if (first_4 < 1 || first_4 > 1237 || middle_4 < 20 || middle_4 > 460 || last_3 > 100) {
                            Aadhaar_illegal = true;
                        } else if ((end == 0 && !Objects.equals(op[2], "F") ||
                                end == 1 && !Objects.equals(op[2], "M")) ||
                                end == 2 && !Objects.equals(op[2], "O")) {
                            Aadhaar_illegal = true;
                        }
                    }
                }
                if (Aadhaar_illegal) {
                    System.out.println("Aadhaar number illegal");
                } else {
                    for (String s : alreadyExisted) {
                        if (Objects.equals(s, op[3])) {
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
                        alreadyExisted.add(op[3]);
                        this.toString();
                    }
                }
            }
        }
    }

    private static boolean isdigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private static boolean isalpha(char c) {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }


}

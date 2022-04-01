import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class User {
    String name;
    String sex;
    String Aadhaar;

    public static List<User> userAlreadyExisted = new ArrayList<>();

    public User() {
    }

    public User(String name, String sex, String Aadhaar) {
        this.name = name;
        this.sex = sex;
        this.Aadhaar = Aadhaar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAadhaar() {
        return Aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        Aadhaar = aadhaar;
    }

    @Override
    public String toString() {
        System.out.println("Name:" + this.name);
        System.out.println("Sex:" + this.sex);
        System.out.println("Aadhaar:" + this.Aadhaar);
        return null;
    }

    void addUser(String[] op) {
        if (op.length != 4) {
            System.out.println("Arguments illegal");
            return;
        }
        boolean Aadhaar_exists = false;
        if (!Pattern.matches("^[A-Za-z_]+$", op[1])) {
            System.out.println("Name illegal");
            return;
        }
        if (!Pattern.matches("^[FMO]$", op[2])) {
            System.out.println("Sex illegal");
            return;
        }
        int end = Integer.parseInt(op[3].substring(11));
        if (!Pattern.matches("^(000[1-9]|00[1-9]\\d|0[1-9]\\d{2}|1[0-1]\\d{2}|12[0-2]\\d|123[0-7])(00[2-9]\\d|0[1-3]\\d{2}|04[0-5]\\d|0460)(0\\d{2}|100)([0-2])$", op[3])) {
            System.out.println("Aadhaar number illegal");
            return;
        }
        if ((end == 0 && !Objects.equals(op[2], "F") ||
                end == 1 && !Objects.equals(op[2], "M")) ||
                end == 2 && !Objects.equals(op[2], "O")) {
            System.out.println("Aadhaar number illegal");
            return;
        }
        for (User u : userAlreadyExisted) {
            if (Objects.equals(u.Aadhaar, op[3])) {
                System.out.println("Aadhaar number exist");
                return;
            }
        }
        this.name = op[1];
        this.sex = op[2];
        this.Aadhaar = op[3];
        User user = new User(op[1], op[2], op[3]);
        userAlreadyExisted.add(user);
        this.toString();
    }
}

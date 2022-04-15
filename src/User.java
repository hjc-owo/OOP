import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class User {
    private String name;
    private String sex;
    private String Aadhaar;

    public static List<User> registeredUsers = new ArrayList<>();
    static User loginUser = null;
    private List<Ticket> tickets = new ArrayList<>();

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
        return "Name:" + this.name + "\nSex:" + this.sex + "\nAadhaar:" + this.Aadhaar;
    }

    static String addUser(String[] op) {
        if (op.length != 4) {
            return "Arguments illegal";
        }
        if (!Pattern.matches("^[A-Za-z_]+$", op[1])) {
            return "Name illegal";
        }
        if (!Pattern.matches("^[FMO]$", op[2])) {
            return "Sex illegal";
        }
        int end = Integer.parseInt(op[3].substring(11));
        if (!Pattern.matches("^(000[1-9]|00[1-9]\\d|0[1-9]\\d{2}|1[0-1]\\d{2}|12[0-2]\\d|123[0-7])(00[2-9]\\d|0[1-3]\\d{2}|04[0-5]\\d|0460)(0\\d{2}|100)([0-2])$", op[3])) {
            return "Aadhaar number illegal";
        }
        if ((end == 0 && !Objects.equals(op[2], "F")) ||
                (end == 1 && !Objects.equals(op[2], "M")) ||
                (end == 2 && !Objects.equals(op[2], "O"))) {
            return "Aadhaar number illegal";
        }
        for (User u : registeredUsers) {
            if (Objects.equals(u.Aadhaar, op[3])) {
                return "Aadhaar number exist";
            }
        }
        User user = new User(op[1], op[2], op[3]);
        registeredUsers.add(user);
        return user.toString();
    }

    static String lineInfo(String[] op) {
        if (op.length != 2) {
            return "Arguments illegal";
        }
        for (Line l : Line.lines) {
            if (Objects.equals(l.id, op[1])) {
                return l.toString();
            }
        }
        return "Line does not exist";

    }

    static String listLine(String[] op) {
        if (op.length != 1) {
            return "Arguments illegal";
        }
        Line.lines.sort(Comparator.comparing(l -> l.id));
        if (Line.lines.isEmpty()) {
            return "No Lines";
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Line.lines.size(); i++) {
            str.append("[").append(i + 1).append("]").append(" ").append(Line.lines.get(i).toString());
            if (i != Line.lines.size() - 1) {
                str.append("\n");
            }
        }
        return str.toString();
    }

    static String listTrain(String[] op) {
        if (op.length > 2 || op.length <= 0) {
            return "Arguments illegal";
        }
        if (op.length == 2) {
            Line line = Line.getLineById(op[1]);
            if (line == null) {
                return "Line does not exist";
            }
            if (line.trainCount == 0) {
                return "No Trains";
            }
            line.trains.sort(new Train.trainComparator());
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < line.trains.size(); i++) {
                showTrain(str, i, line.trains.size(), line);
            }
            return str.toString();
        } else {
            List<Train> allTrains = new ArrayList<>();
            for (Line l : Line.lines) {
                allTrains.addAll(l.trains);
            }
            if (allTrains.size() == 0) {
                return "No Trains";
            }
            allTrains.sort(new Train.trainComparator());
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < allTrains.size(); i++) {
                Line line = Line.getLineById(allTrains.get(i).lineId);
                assert line != null;
                showTrain(str, i, allTrains.size(), line);
            }
            return str.toString();
        }
    }

    private static void showTrain(StringBuilder str, int i, int size, Line line) {
        String seat = String.valueOf(line.trains.get(i).id.charAt(0));
        int innerSize = seat.equals("K") ? 2 : 3;
        str.append("[").append(i + 1).append("]").append(" ")
                .append(line.trains.get(i).id).append(": ")
                .append(line.id).append(" ");
        for (int j = 1; j <= innerSize; j++) {
            str.append("[").append(Train.seat.get(seat + j)).append("]")
                    .append(String.format("%.2f", line.trains.get(i).price[j]))
                    .append(":").append(line.trains.get(i).count[j]).append(" ");
        }
        if (i != size - 1) {
            str.append("\n");
        }
    }

    static String login(String[] op) {
        if (op.length != 3) {
            return "Arguments illegal";
        }
        if (loginUser != null) {
            return "You have logged in";
        }
        if (!Pattern.matches("^(000[1-9]|00[1-9]\\d|0[1-9]\\d{2}|1[0-1]\\d{2}|12[0-2]\\d|123[0-7])(00[2-9]\\d|0[1-3]\\d{2}|04[0-5]\\d|0460)(0\\d{2}|100)([0-2])$", op[1])) {
            return "User does not exist";
        }
        for (User u : User.registeredUsers) {
            if (Objects.equals(u.Aadhaar, op[1])) {
                if (!Objects.equals(u.name, op[2])) {
                    return "Wrong name";
                } else {
                    loginUser = u;
                    return "Login success";
                }
            }
        }
        return "User does not exist";
    }

    static String logout(String[] op) {
        if (op.length != 1) {
            return "Arguments illegal";
        }
        if (loginUser == null) {
            return "No user has logged in";
        }
        loginUser = null;
        return "Logout success";
    }

    public static int match(String trainId, String kind) {
        if (trainId.charAt(0) == 'G') {
            if (Objects.equals(kind, "SC")) {
                return 1;
            }
            if (Objects.equals(kind, "HC")) {
                return 2;
            }
            if (Objects.equals(kind, "SB")) {
                return 3;
            }
            return 0;
        } else if (trainId.charAt(0) == 'K') {
            if (Objects.equals(kind, "1A")) {
                return 1;
            }
            if (Objects.equals(kind, "2A")) {
                return 2;
            }
            return 0;
        } else if (trainId.charAt(0) == '0') {
            if (Objects.equals(kind, "CC")) {
                return 1;
            }
            if (Objects.equals(kind, "SB")) {
                return 2;
            }
            if (Objects.equals(kind, "GG")) {
                return 3;
            }
            return 0;
        }
        return 0;
    }

    static String buyTicket(String[] op) {
        if (op.length != 6) {
            return "Arguments illegal";
        }
        if (loginUser == null) {
            return "Please login first";
        }
        Train train = Train.getTrainById(op[1]);
        if (train == null || !Train.trains.contains(train)) {
            return "Train does not exist";
        }
        Line line = Train.getLineByTrain(Train.getTrainById(op[1]));
        if (line == null) {
            return "Train does not exist";
        }
        if (!line.stations.containsKey(op[2]) || !line.stations.containsKey(op[3])) {
            return "Station does not exist";
        }
        if (!Train.seat.containsValue(op[4])) {
            return "Seat does not match";
        }
        int kind = match(op[1], op[4]);
        if (kind == 0) {
            return "Seat does not match";
        }
        if (Integer.parseInt(op[5]) <= 0) {
            return "Ticket number illegal";
        }
        if (Integer.parseInt(op[5]) > train.count[kind]) {
            return "Ticket does not enough";
        }
        train.count[kind] -= Integer.parseInt(op[5]);

        Ticket ticket = new Ticket(train, line, op[2], op[3], op[4], Integer.parseInt(op[5]),
                train.price[kind] * (line.stations.get(op[3]) - line.stations.get(op[2])) * Integer.parseInt(op[5]));
        loginUser.tickets.add(ticket);
        return "Thanks for your order";
    }

    static String listOrder(String[] op) {
        if (op.length != 1) {
            return "Arguments illegal";
        }
        if (loginUser == null) {
            return "Please login first";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = loginUser.tickets.size() - 1; i >= 0; i--) {
            sb.append(loginUser.tickets.get(i).toString());
            if (i != 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

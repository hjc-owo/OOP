import java.util.Objects;
import java.util.regex.Pattern;

public class NormalUser extends User {

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

    public static String checkTicket(String[] op, boolean isSuperAdmins) {
        if (isSuperAdmins) {
            return "Command does not exist";
        }
        if (op.length != 5) {
            return "Arguments illegal";
        }
        if (!Pattern.matches("^[GK0]+\\d{4}$", op[1])) {
            return "Train serial illegal";
        }
        Train train = Train.getTrainById(op[1]);
        if (train == null) {
            return "Train serial does not exist";
        }
        Line line = Line.getLineById(train.lineId);
        if (line == null) {
            return "Line does not exist";
        }
        if (!line.station.containsKey(op[2]) || !line.station.containsKey(op[3])) {
            return "Station does not exist";
        }
        int kind = match(op[1], op[4]);
        if (kind == 0) {
            return "Seat does not match";
        }
        String str = "[";
        str += op[1] + ": " + op[2] + "->" + op[3]
                + "] seat:" + op[4]
                + " remain:" + train.count[kind]
                + " distance:" + (line.station.get(op[3]) - line.station.get(op[2]))
                + " price:" + String.format("%.2f", train.price[kind] * (line.station.get(op[3]) - line.station.get(op[2])));
        return str;
    }

}

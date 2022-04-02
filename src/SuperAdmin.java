import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class SuperAdmin extends User {

    String addLine(String[] op, boolean isSuperAdmins) {
        if (!isSuperAdmins) {
            return "Command does not exist";
        }
        if ((op.length - 1) % 2 != 0) {
            return "Arguments illegal";
        }
        for (int i = 4; i < op.length - 1; i += 2) {
            if (!Pattern.matches(op[i], "^[0-9]+$")) {
                return "Arguments illegal";
            }
        }
        for (int i = 3; i < op.length - 1; i += 2) {
            for (int j = i + 2; j < op.length - 1; j += 2) {
                if (Objects.equals(op[i], op[j])) {
                    return "Station duplicate";
                }
            }
        }
        for (Line l : Line.lines) {
            if (Objects.equals(op[1], l.id)) {
                return "Line already exists";
            }
        }
        if (Integer.parseInt(op[2]) <= 0) {
            return "Capacity illegal";
        }

        Map<String, Integer> station = new HashMap<>();
        Line line = new Line(op[0], Integer.parseInt(op[1]), station);
        for (int i = 3; i < op.length - 1; i += 2) {
            line.station.put(op[i], Integer.parseInt(op[i + 1]));
        }
        Line.lines.add(line);
        return "Add Line success";
    }

    String delLine(String[] op, boolean isSuperAdmins) {
        if (!isSuperAdmins) {
            return "Command does not exist";
        }
        if (op.length != 2) {
            return "Arguments illegal";
        }
        if (Line.lines.removeIf(l -> Objects.equals(op[1], l.id))) {
            return "Del Line success";
        } else {
            return "Line does not exist";
        }
    }

    String addStation(String[] op, boolean isSuperAdmins) {
        if (!isSuperAdmins) {
            return "Command does not exist";
        }
        if (op.length != 4) {
            return "Arguments illegal";
        }

        Line line = Line.getLineById(op[1]);
        if (line == null) {
            return "Line does not exist";
        }
        if (line.station.containsKey(op[2])) {
            return "Station duplicate";
        }
        if (!Pattern.matches(op[3], "^[0-9]+$")) {
            return "Arguments illegal";
        }

        line.station.put(op[2], Integer.parseInt(op[3]));
        return "Add Station success";

    }

    String delStation(String[] op, boolean isSuperAdmins) {
        if (!isSuperAdmins) {
            return "Command does not exist";
        }
        if (op.length != 3) {
            return "Arguments illegal";
        }
        Line line = Line.getLineById(op[1]);
        if (line == null) {
            return "Line does not exist";
        }
        if (line.station.containsKey(op[2])) {
            line.station.remove(op[2]);
            return "Delete Station success";
        } else {
            return "Station does not exist";
        }

    }

    String addTrain(String[] op, boolean isSuperAdmins) {
        if (!isSuperAdmins) {
            return "Command does not exist";
        }
        if (!Pattern.matches(op[1], "^[GK0]+\\d{4}$")) {
            return "Train serial illegal";
        }
        if ((op[1].charAt(0) == 'K' && op.length != 7) ||
                (op[1].charAt(0) != 'K' && op.length != 9)) {
            return "Arguments illegal";
        }
        if (Train.getTrainById(op[1]) != null) {
            return "Train serial duplicate";
        }

        Line line = Line.getLineById(op[2]);
        if (line == null) {
            return "Line illegal";
        }
        if (line.trainCount >= line.capacity) {
            return "Line illegal";
        }

        double[] price = new double[4];
        int[] count = new int[4];
        price[1] = Double.parseDouble(op[3]);
        count[1] = Integer.parseInt(op[4]);
        price[2] = Double.parseDouble(op[5]);
        count[2] = Integer.parseInt(op[6]);
        if (op[1].charAt(0) != 'K') {
            price[3] = Double.parseDouble(op[7]);
            count[3] = Integer.parseInt(op[8]);
        }

        if (price[1] <= 0 || price[2] <= 0) {
            return "Price illegal";
        }
        if (op[1].charAt(0) != 'K') {
            if (price[3] <= 0) {
                return "Price illegal";
            }
        }

        if (count[1] <= 0 || count[2] <= 0) {
            return "Ticket num illegal";
        }
        if (op[1].charAt(0) != 'K') {
            if (count[3] <= 0) {
                return "Ticket num illegal";
            }
        }

        Train train = new Train(op[1], op[2], price, count);
        line.trainCount++;
        Train.trains.add(train);
        return "Add Train Success";
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class SuperAdmin extends User {

    void addLine(String[] op) {
        if ((op.length - 1) % 2 != 0) {
            System.out.println("Arguments illegal");
            return;
        }
        for (int i = 4; i < op.length - 1; i += 2) {
            if (!Pattern.matches(op[i], "^[0-9]+$")) {
                System.out.println("Arguments illegal");
                return;
            }
        }
        for (int i = 3; i < op.length - 1; i += 2) {
            for (int j = i + 2; j < op.length - 1; j += 2) {
                if (Objects.equals(op[i], op[j])) {
                    System.out.println("Station duplicate");
                    return;
                }
            }
        }
        for (Line l : Line.lines) {
            if (Objects.equals(op[1], l.id)) {
                System.out.println("Line already exists");
                return;
            }
        }
        if (Integer.parseInt(op[2]) <= 0) {
            System.out.println("Capacity illegal");
            return;
        }

        Map<String, Integer> station = new HashMap<>();
        Line line = new Line(op[0], Integer.parseInt(op[1]), station);
        for (int i = 3; i < op.length - 1; i += 2) {
            line.station.put(op[i], Integer.parseInt(op[i + 1]));
        }
        Line.lines.add(line);
        System.out.println("Add Line success");
    }

    void delLine(String[] op) {
        if (op.length != 2) {
            System.out.println("Arguments illegal");
            return;
        }
        if (Line.lines.removeIf(l -> Objects.equals(op[1], l.id))) {
            System.out.println("Del Line success");
        } else {
            System.out.println("Line does not exist");
        }
    }

    void addStation(String[] op) {
        if (op.length != 4) {
            System.out.println("Arguments illegal");
            return;
        }

        Line line = Line.getLineById(op[1]);
        if (line == null) {
            System.out.println("Line does not exist");
            return;
        }
        if (line.station.containsKey(op[2])) {
            System.out.println("Station duplicate");
            return;
        }
        if (!Pattern.matches(op[3], "^[0-9]+$")) {
            System.out.println("Arguments illegal");
            return;
        }

        line.station.put(op[2], Integer.parseInt(op[3]));
        System.out.println("Add Station success");

    }

    void delStation(String[] op) {
        if (op.length != 3) {
            System.out.println("Arguments illegal");
            return;
        }
        Line line = Line.getLineById(op[1]);
        if (line == null) {
            System.out.println("Line does not exist");
            return;
        }
        if (line.station.containsKey(op[2])) {
            line.station.remove(op[2]);
            System.out.println("Delete Station success");
        } else {
            System.out.println("Station does not exist");
        }

    }


}

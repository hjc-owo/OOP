import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class SuperAdmin extends User {

    void addLine(String argStr) {
        String[] op = argStr.split(" ");
        if (op.length % 2 != 0) {
            System.out.println("Arguments illegal");
            return;
        }
        for (int i = 3; i < op.length; i += 2) {
            if (!Pattern.matches(op[i], "^[0-9]+$")) {
                System.out.println("Arguments illegal");
                return;
            }
        }
        for (int i = 2; i < op.length; i += 2) {
            for (int j = i + 2; j < op.length; j += 2) {
                if (Objects.equals(op[i], op[j])) {
                    System.out.println("Station duplicate");
                    return;
                }
            }
        }
        for (Line l : Line.lines) {
            if (Objects.equals(op[0], l.id)) {
                System.out.println("Line already exists");
                return;
            }
        }
        if (Integer.parseInt(op[1]) <= 0) {
            System.out.println("Capacity illegal");
            return;
        }

        List<String> stationName = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();
        for (int i = 2, j = 0; i < op.length; i += 2, j++) {
            stationName.add(op[i]);
            distance.add(Integer.parseInt(op[i + 1]));
        }
        Line line = new Line(op[0], Integer.parseInt(op[1]), stationName, distance);
        Line.lines.add(line);
        System.out.println("Add Line success");
    }

    void delLine(String argStr) {
        String[] op = argStr.split(" ");
        if (op.length != 1) {
            System.out.println("Arguments illegal");
            return;
        }
        if (Line.lines.removeIf(l -> Objects.equals(op[0], l.id))) {
            System.out.println("Del Line success");
        } else {
            System.out.println("Line does not exist");
        }
    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Line {
    String id;
    int trainCount = 0;
    int capacity;
    Map<String, Integer> station;

    public static List<Line> lines = new ArrayList<>();

    public Line(String id, int capacity, Map<String, Integer> station) {
        this.id = id;
        this.capacity = capacity;
        this.station = station;
    }

    public static Line getLineById(String id) {
        for (Line l : Line.lines) {
            if (Objects.equals(l.id, id)) {
                return l;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        System.out.print(id + " " + trainCount + "/" + capacity + " ");
        for (Map.Entry<String, Integer> entry : station.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println();
        return null;
    }

}

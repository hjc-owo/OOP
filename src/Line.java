import java.util.ArrayList;
import java.util.List;

public class Line {
    String id;
    int capacity;
    List<String> stationName;
    List<Integer> distance;

    public static List<Line> lines = new ArrayList<>();

    public Line(String id, int capacity, List<String> stationName, List<Integer> distance) {
        this.id = id;
        this.capacity = capacity;
        this.stationName = stationName;
        this.distance = distance;
    }

}

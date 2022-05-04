import java.util.*;

public class Line {
    String id;
    int trainCount = 0;
    int capacity;
    Map<String, Integer> stations;
    List<Train> trains;

    public static List<Line> lines = new ArrayList<>();

    public Line(String id, int capacity, Map<String, Integer> stations, List<Train> trains) {
        this.id = id;
        this.capacity = capacity;
        this.stations = stations;
        this.trains = trains;
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
        Map<Integer, String> stations = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : this.stations.entrySet()) {
            stations.put(entry.getValue(), entry.getKey());
        }
        Map<Integer, String> resultStation = sortMapByKey(stations);

        StringBuilder str = new StringBuilder(id + " " + trainCount + "/" + capacity + " ");
        for (Map.Entry<Integer, String> entry : resultStation.entrySet()) {
            str.append(entry.getValue()).append(":").append(entry.getKey()).append(" ");
        }
        return str.toString();
    }

    public static Map<Integer, String> sortMapByKey(Map<Integer, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer, String> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

}

class MapKeyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer integer1, Integer integer2) {
        return integer1.compareTo(integer2);
    }
}

import java.util.*;

public class Train {

    String id;
    String lineId;
    double[] price;
    int[] count;
    public static Map<String, String> seat = new HashMap<>();

    public static List<Train> trains = new ArrayList<>();

    public Train(String id, String lineId, double[] price, int[] count) {
        this.id = id;
        this.lineId = lineId;
        this.price = price;
        this.count = count;
    }

    public static Train getTrainById(String id) {
        for (Train train : trains) {
            if (Objects.equals(train.id, id)) {
                return train;
            }
        }
        return null;
    }

    public static void init() {
        seat.put("01", "CC");
        seat.put("02", "SB");
        seat.put("03", "GG");
        seat.put("G1", "SC");
        seat.put("G2", "HC");
        seat.put("G3", "SB");
        seat.put("K1", "1A");
        seat.put("K2", "2A");
    }

    static class trainComparator implements Comparator<Object> {
        public int compare(Object object1, Object object2) {
            Train train1 = (Train) object1;
            Train train2 = (Train) object2;
            if (train1.id.charAt(0) == train2.id.charAt(0)) {
                return train1.id.compareTo(train2.id);
            }
            if (train1.id.charAt(0) == 'K') {
                return -1;
            }
            if (train2.id.charAt(0) == 'K') {
                return 1;
            }
            if (train1.id.charAt(0) == 'G') {
                return -1;
            }
            return 1;
        }
    }
}


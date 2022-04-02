import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Train {

    String id;
    String lineId;
    double[] price;
    int[] count;

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

}

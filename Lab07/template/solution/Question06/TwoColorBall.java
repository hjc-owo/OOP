import java.util.HashMap;
import java.util.Map;

public class TwoColorBall {
    public static void main(String[] args) {
        /* Your code here */
        Map<Integer, String> map = new HashMap<>();
        while (map.size() < 6) {
            int num = (int) (Math.random() * 33) + 1;
            if (!map.containsKey(num)) {
                map.put(num, "红球");
            }
        }
        int num = (int) (Math.random() * 16) + 1;
        map.put(num, "蓝球");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
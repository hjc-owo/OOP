import java.util.HashMap;
import java.util.Map;

public class EmailSplit {
    public static void main(String[] args) {
        String str = "aa@sohu.com,bb@163.com,cc@sina.com";
        Map<String, String> emailMap = new HashMap<String, String>();
        /* Your code here */
        String[] emails = str.split(",");
        for (String email : emails) {
            String[] emailArr = email.split("@");
            emailMap.put(emailArr[0], emailArr[1]);
        }
        System.out.println(emailMap.toString());
    }
}
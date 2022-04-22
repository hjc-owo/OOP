public class Strscat {
    public static void main(String[] args){
        System.out.println(strscat("a", "b", "c", "", "e"));
    }

    public static String strscat(String... args){
        String newString = "";
        for(String str : args){
            newString += str;
        }
        return newString;
    }
}

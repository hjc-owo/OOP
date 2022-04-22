public class Square {
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cnt++ + " ");
            }
            System.out.println();
        }
    }
}

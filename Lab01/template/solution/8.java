public class Star {
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        int line = 0;
        for (; line <= n / 2; line++) {
            for (int i = 0; i < (n - 2 * line) / 2; i++)
                System.out.print(" ");
            for (int j = 0; j < 2 * line + 1; j++)
                System.out.print("*");
            System.out.println();
        }
        for (; line < n; line++) {
            for (int i = 0; i < (2 * line - n) / 2 + 1; i++)
                System.out.print(" ");
            for (int j = 0; j < 2 * (n - line) - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}

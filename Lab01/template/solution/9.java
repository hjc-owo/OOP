import java.util.Scanner;

public class GetPi {
    public static double getPi(int n) {
        if (n <= 0) n = 0;
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = ((i & 1) == 1 ? sum - 1.0 / (2 * i + 1) : sum + 1.0 / (2 * i + 1));
        }
        return 4 * sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(getPi(n));
    }
}

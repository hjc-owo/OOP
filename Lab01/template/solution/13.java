import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        int arr[] = {12, 45, 67, 89, 123, -45, 67};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }System.out.println("");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        boolean have = false;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x) {
                have = true;
                break;
            }
        if (have) {
            System.out.println(x + " is in the array.");
        } else {
            System.out.println(x + " is not in the array.");
        }
    }
}


import java.util.Scanner;

public class Palindrome {
    static char[] cc;
    static String str;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        str = input.nextLine();
        cc = str.toCharArray();
        boolean flag = false;
        for (char c : cc) {
            if (!isdigit(c)) {
                flag = true;
                break;
            }
        }

        if (!flag && ((str.length() > 1 && cc[0] != '0') || (str.length() == 1))) {
            System.out.println("是没有前导 0 的无符号整数");
            System.out.println(isPalindrome() ? "回文数" : "不是回文数");
        } else {
            System.out.println("不是没有前导 0 的无符号整数");
        }
    }

    private static boolean isdigit(char c) {
        return (c >= '0' && c <= '9');
    }

    public static boolean isPalindrome() {
        int i, j;
        for (j = str.length() - 1; j > 0 && cc[j] == '0'; j--) ;
        for (i = 0; i < j; i++, j--)
            if (cc[i] != cc[j])
                return false;
        return true;
    }
}


public class Qsort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 6, 1, 2, 8, 7};
        System.out.println(arr.length);
        qsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] qsort(int arr[]) {
        if (arr == null)
            return null;
        return qsort(arr, 0, arr.length - 1);
    }

    public static int[] qsort(int arr[], int start, int end) {
        int x = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && arr[j] > x)
                j--;
            while (i < j && arr[i] < x)
                i++;
            if (arr[i] == arr[j] && i < j)
                i++;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) arr = qsort(arr, start, i - 1);
        if (j + 1 < end) arr = qsort(arr, j + 1, end);
        return arr;
    }
}

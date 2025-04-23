import java.util.Arrays;

public class F2_Good_Integer_Distinct {
    public static void main(String[] args) {
        int[] arr = { -1, -4, 3, 5, -15, 4 };
        System.out.println(goodInteger(arr));

        int[] arr1 = { -6, 4, 2, 5, 1, 7 };
        System.out.println(goodInteger(arr1));
    }

    public static int goodInteger(int arr[]) {
        Arrays.sort(arr);

        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == i) {
                count++;
            }
        }
        return count;
    }
}
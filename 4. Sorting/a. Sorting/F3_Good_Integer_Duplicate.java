import java.util.Arrays;

public class F3_Good_Integer_Duplicate {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 2, 3, 1, 3 };
        System.out.println(goodInteger(arr));
    }

    public static int goodInteger(int arr[]) {
        Arrays.sort(arr);

        int n = arr.length;
        int count = 0;
        int ubiqueIndex = 0;

        if (arr[0] == 0) {
            count++;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                ubiqueIndex = i;
            }
            if (arr[i] == ubiqueIndex) {
                count++;
            }
        }
        return count;
    }
}
public class L2a_Same_Difference {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 1, 4, 6, 6 };
        System.out.println(sameDifference(arr)); // 1

        int arr2[] = { 1, 6, 3, 4, 5, 6 };
        System.out.println(sameDifference(arr2)); // 10
    }

    public static int sameDifference(int[] arr) {
        int n = arr.length;
        int ans = 0;

        // Check every pair (i, j) with i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // If difference is same, count this pair
                if (arr[i] - i == arr[j] - j) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
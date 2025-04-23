import java.util.Arrays;

public class F1_Order_of_Removal {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };

        int minCost = calculateCost(arr, false); // minimize
        int maxCost = calculateCost(arr, true); // maximize

        System.out.println("Min Cost: " + minCost); // Output: 10
        System.out.println("Max Cost: " + maxCost); // Output: 14

    }

    public static int calculateCost(int[] arr, boolean maximize) {
        Arrays.sort(arr);
        int n = arr.length;
        int ans = 0;
        if (maximize) {
            for (int i = n - 1; i >= 0; i--) {
                ans += arr[i] * (i + 1); // Larger elements get higher weights
            }
        } else {
            for (int i = 0; i < n; i++) {
                ans += arr[i] * (n - i); // Smaller elements get higher weights
            }
        }
        return ans;
    }
}
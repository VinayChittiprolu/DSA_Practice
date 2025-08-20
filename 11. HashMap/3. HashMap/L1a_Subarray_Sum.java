public class L1a_Subarray_Sum {
    public static void main(String[] args) {
        int num[] = { 1, 2, 3 };
        int k = 3;
        System.out.println("No. of subArrays: " + subArraySumBruteForce(num, k));
    }

public static int subArraySumBruteForce(int[] num, int k) {
    int n = num.length;
    int count = 0;

    // Check all possible subarrays
    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
            sum += num[j]; // Add current element to sum

            if (sum == k) {
                count++; // Found a subarray with sum k
            }
        }
    }

    return count;
}
}
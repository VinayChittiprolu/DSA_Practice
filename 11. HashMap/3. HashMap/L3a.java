public class L3a {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 1, 0, 1, 1 };
        int[] arr1 = { 0, 1, 0, 1 };

        System.out.println("Subarrays with 0s and 1s: " + subarrayCountBruteForce(arr));
        System.out.println("Subarrays with 0s and 1s: " + subarrayCountBruteForce(arr1));
    }

    public static int subarrayCountBruteForce(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int zeros = 0;
            int ones = 0;

            // Count the number of 0s and 1s in the subarray starting from index i
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros == ones) {
                    count++;
                }
            }
        }

        return count;
    }
}

/*
 * Time and Space Complexity
 * Time: O(n²) — Two nested loops
 * Space: O(1) — No extra data structures used (in-place sum)
 */
import java.util.HashMap;

public class L3b_Subarray_eql_0s_1s {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 1, 0, 1, 1 };
        System.out.println("Subarrays with 0s and 1s: " + subarrayCount(arr));

        int[] arr1 = { 0, 1, 0, 1 };
        System.out.println("Subarrays with 0s and 1s: " + subarrayCount(arr1));
    }

    // Function to count subarrays with equal number of 0s and 1s
    public static int subarrayCount(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Put initial entry into the map to handle subarrays starting from index 0

        // Calculate prefix counts of 0s and 1s in the array
        int[] zeros = count(arr, 0);
        int[] ones = count(arr, 1);

        int ans = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Calculate the difference btw the counts of 1s and 0s up to the current index
            int diff = ones[i] - zeros[i];

            // If this difference has been seen before, add its frequency to the answer
            ans += map.getOrDefault(diff, 0);
            // Update the frequency of this difference in the map
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        return ans; // Return the total count of subarrays with equal number of 0s and 1s
    }

    // Helper function to calculate prefix counts of a specified number (0 or 1) in
    // the array
    public static int[] count(int[] arr, int num) {
        int n = arr.length;
        int[] ans = new int[n];

        int count = 0;

        // Iterate through the array to calculate prefix counts
        for (int i = 0; i < n; i++) {
            // Increment the counter if the current element matches the specified number
            if (arr[i] == num) {
                count++;
            }

            ans[i] = count; // Store the current count in the ans array
        }
        // Return the array of prefix counts
        return ans;
    }
}
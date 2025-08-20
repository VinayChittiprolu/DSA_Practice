import java.util.HashMap;

public class L6_Longest_Subarray_K {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        System.out.println("The length of the longest subarray with sum " + k + " is: " + longestSubarray(arr, k));

        int arr1[] = { -1, 2, 3 };
        int k1 = 6;
        System.out.println("The length of the longest subarray with sum " + k1 + " is: " + longestSubarray(arr1, k1));
    }

    public static int longestSubarray(int[] arr, int K) {
        // HashMap to store the cumulative sums and their earliest occurrence indices
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initializing the map with an initial sum of 0 at index -1

        int sum = 0; // Variable to store the cumulative sum
        int maxLength = 0; // Variable to store the length of the longest subarray

        // Iterating over each element of the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Updating the cumulative sum

            // If (sum - K) exists in the map, update maxLength
            if (map.containsKey(sum - K)) {
                int length = i - map.get(sum - K); // Calculate the length of the current subarray
                maxLength = Math.max(maxLength, length); // Update the maximum length
            }

            // Add the current sum to the map if it is not already present
            if (!map.containsKey(sum)) {
                map.put(sum, i); // Storing the earliest occurrence index of the sum
            }
        }

        return maxLength; // Returning the length of the longest subarray
    }
}
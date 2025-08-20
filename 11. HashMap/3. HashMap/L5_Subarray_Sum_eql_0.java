import java.util.HashMap;

public class L5_Subarray_Sum_eql_0 {
    public static void main(String[] args) {
        int arr[] = { 0, 0, 5, 5, 0, 0 };
        System.out.println(countSubarrays(arr));

        int[] arr1 = { 6, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        System.out.println(countSubarrays(arr1));
    }

    public static int countSubarrays(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Create a map to store prefix sums and their frequencies
        map.put(0, 1); // Initialize the map with 0 sum having frequency 1

        int count = 0; // Initialize the counter for the number of subarrays with sum equal to 0
        int prefixSum = 0; // Initialize prefix sum

        // Iterate over each element in the array
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i]; // Update prefix sum with the current element

            // If prefix sum is already in the map, increment count by its frequency
            count += map.getOrDefault(prefixSum, 0);
            // Update map with current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count; // Return the total count of subarrays with sum equal to 0
    }
}
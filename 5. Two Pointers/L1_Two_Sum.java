import java.util.Arrays;
import java.util.HashMap;

public class L1_Two_Sum {
    public static void main(String[] args) {
        int arr[] = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));

        int arr1[] = { 3, 2, 4 };
        int target1 = 6;
        System.out.println(Arrays.toString(twoSum(arr1, target1)));

        int arr2[] = { 3, 3 };
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(arr2, target2)));
    }

    public static int[] twoSum(int nums[], int target) {
        // Map to store number as key and its index as value
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int complementNum = target - nums[i]; // Calculate the number needed to reach the target

            // Check if the complementNum is already in the map
            if (hm.containsKey(complementNum)) {
                // If found, return the indices of the complementNum and current number
                int[] indices = { hm.get(complementNum), i };
                return indices;
            }

            hm.put(nums[i], i); // Otherwise, store the current number and its index in the map
        }
        return null; // If no such pair is found, return null
    }
}
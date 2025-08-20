import java.util.HashMap;

public class L3c {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 1, 0, 1, 1 };
        int[] arr1 = { 0, 1, 0, 1 };

        System.out.println("Subarrays with 0s and 1s: " + subarrayCount(arr));
        System.out.println("Subarrays with 0s and 1s: " + subarrayCount(arr1));
    }

    public static int subarrayCount(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize the map with 0 sum having frequency 1

        int sum = 0;
        int count = 0;

        // Iterate through the array to calculate the sum of 1s and -1s
       for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum += 1;
            } else {
                sum += -1;
            }

            count += map.getOrDefault(sum, 0); // If this sum has been seen before, add its frequency to the count
            map.put(sum, map.getOrDefault(sum, 0) + 1); // Update the frequency of this sum in the map
        }

        return count;
    }
}
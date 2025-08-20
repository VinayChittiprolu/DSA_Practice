import java.util.HashMap;
 
public class L2b_Same_Difference {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 1, 4, 6, 6 };
        System.out.println(sameDifference(arr)); // 1

        int arr2[] = { 1, 6, 3, 4, 5, 6 };
        System.out.println(sameDifference(arr2)); // 10
    }

    public static int sameDifference(int[] arr) {
        // Initialize a HashMap to store the frequency of each difference (arr[i] - i)
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = arr.length;
        int count = 0; // Variable to store the count of valid pairs

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            int key = arr[i] - i; // Calculate the difference for the current index
            count += map.getOrDefault(key, 0); // If this difference has been seen before, increment the count
            map.put(key, map.getOrDefault(key, 0) + 1); // Update the count of this difference in the map
        }

        return count;
    }
}
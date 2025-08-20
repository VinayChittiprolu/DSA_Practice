import java.util.HashMap;

public class F4_Pair_Sum {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        System.out.println(pairSum(arr, 16));

        int[] arr2 = { 1, 2, 3, 4, 5 };
        System.out.println(pairSum(arr2, 10));
    }

    public static boolean pairSum(int[] arr, int k) {
        int n = arr.length; // Get the length of the array
        HashMap<Integer, Integer> map = new HashMap<>(); // Initialize a HashMap to store the frequency of each element

        // Populate the HashMap with the frequency of each element in the array
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int temp = map.get(arr[i]); // Get the current count of the element
                map.put(arr[i], temp + 1); // Increment the count if the element already exists in the HashMap
            } else {
                map.put(arr[i], 1); // Add the element to the HashMap with a count of 1 if it does not exist
            }
        }

        // Iterate through the array to find pairs sum k
        for (int i = 0; i < n; i++) {
            int a = arr[i]; // Current element
            int b = k - a; // The value needed to sum up to k with a

            if ((a != b && map.containsKey(b)) || (a == b && map.get(b) > 1)) {
                return true;
            }
        }
        return false; // Return false if no such pair is found
    }
}
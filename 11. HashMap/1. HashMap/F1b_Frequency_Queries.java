import java.util.HashMap;

public class F1b_Frequency_Queries {
    public static void main(String[] args) {
        int[] arr = { 2, 8, 6, 9, 8, 6, 8, 2, 11 };
        int[] queries = { 2, 8 };
        System.out.println("First Queries: ");
        frequencyQueries(arr, queries); // 2 3

        int[] arr1 = { 1, 2, 2, 3, 3 };
        int[] queries1 = { 2, 3, 4 };
        System.out.println("Second Queries: ");
        frequencyQueries(arr1, queries1); // 2 2 0
    }

    public static void frequencyQueries(int[] arr, int[] queries) {
        // Create a HashMap to store the frequency of each element in arr
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through each element in arr to populate the frequency map
        for (int i = 0; i < arr.length; i++) {
            // Check if the element is already in the map
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]); // count stores the key of arr[i]
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // Iterate through each element in queries to print the frequency of each
        // queried element
        for (int i = 0; i < queries.length; i++) {
            // Check if the queried element is in the frequency map
            if (map.containsKey(queries[i])) {
                System.out.println(map.get(queries[i]) + " "); // prints the key of queries[i]
            } else {
                System.out.println(0 + " ");
            }
        }
    }
}
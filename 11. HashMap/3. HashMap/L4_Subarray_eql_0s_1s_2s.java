import java.util.HashMap;

public class L4_Subarray_eql_0s_1s_2s {
    public static void main(String[] args) {
        String str = "11100022";
        System.out.println("Substrings with equal numbers of 0s, 1s, and 2s: " + countEquals(str));

        String str1 = "0102010";
        System.out.println("Substrings with equal numbers of 0s, 1s, and 2s: " + countEquals(str1));
    }

    // Method to count the number of subarrays with equal counts of '0's, '1's, and
    // '2's
    public static long countEquals(String str) {
        // HashMap to store the counts of differences between the count of '0's, '1's,
        // and '0's, '2's
        HashMap<String, Long> map = new HashMap<>();
        map.put("0#0", 1L); // Initializing the map with an empty prefix

        // Arrays to store the count of '0's, '1's, and '2's up to each index of the
        // string
        int[] pc0 = count(str, '0');
        int[] pc1 = count(str, '1');
        int[] pc2 = count(str, '2');

        long ans = 0; // Variable to store the final count of subarrays

        // Iterating over each index of the string
        for (int i = 0; i < str.length(); i++) {
            // Calculating the difference between the counts of '0's and '1's, and '0's and
            // '2's up to the current index
            int diff1 = pc0[i] - pc1[i];
            int diff2 = pc0[i] - pc2[i];

            // Creating a key representing the difference between counts and retrieving its
            // value from the map
            String diff = diff1 + "#" + diff2;
            ans += map.getOrDefault(diff, 0L); // Adding the count to the final answer
            map.put(diff, map.getOrDefault(diff, 0L) + 1); // Updating the count in the map
        }

        return ans; // Returning the final count of subarrays
    }

    // Method to count the occurrences of a character up to each index of the string
    public static int[] count(String str, char num) {
        int n = str.length();
        int[] ans = new int[n]; // Array to store the counts
        int count = 0; // Variable to store the count

        // Iterating over each index of the string
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == num) { // Checking if the character at current index is equal to 'num'
                count++; // Incrementing the count
            }
            ans[i] = count; // Storing the count up to the current index
        }
        return ans; // Returning the array of counts
    }
}
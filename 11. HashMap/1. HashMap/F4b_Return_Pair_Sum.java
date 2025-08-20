import java.util.HashSet;

public class F4b_Return_Pair_Sum {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int[] pair = getFirstPairWithSum(arr, 10);
        if (pair != null) {
            System.out.println("Pair: " + pair[0] + ", " + pair[1]);
        } else {
            System.out.println("No such pair found.");
        }

        int[] arr2 = { 1, 2, 3, 4, 5 };
        int[] pair2 = getFirstPairWithSum(arr2, 10);
        if (pair2 != null) {
            System.out.println("Pair: " + pair2[0] + ", " + pair2[1]);
        } else {
            System.out.println("No such pair found.");
        }
    }

    public static int[] getFirstPairWithSum(int[] arr, int k) {
        int n = arr.length; // Get the length of the array
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int pair = k - arr[i]; // Calculate the required pair value

            if (set.contains(pair)) {
                return new int[] { pair, arr[i] }; // Return the pair if found
            }
            set.add(arr[i]); // Add the current element to the HashMap
        }
        return null; // Return an empty array if no pair is found
    }
}
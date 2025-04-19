public class L16a_Sum_of_XOR {
    public static void main(String[] args) {
        int[] arr = { 5, 9, 7, 6 };
        System.out.println("Total sum of all pairs is: " + sumXOR(arr));
    }

    public static long sumXOR(int[] arr) {
        long sum = 0; // Variable to store the total XOR sum
        int n = arr.length; // Get the size of the array

        // Iterate over all pairs (i, j) where i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Compute XOR of the current pair and add to the sum
                sum += arr[i] ^ arr[j];
            }
        }

        // Return the final result
        return sum;
    }
}
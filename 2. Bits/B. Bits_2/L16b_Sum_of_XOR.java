public class L16b_Sum_of_XOR {
    public static void main(String[] args) {
        int[] arr = { 5, 9, 7, 6 };
        System.out.println("Total sum of all pairs is: " + sumXOR(arr));
    }

    public static long sumXOR(int[] arr) {
        long sum = 0;

        // Loop over each bit position from 31 (MSB) to 0 (LSB)
        for (int bit = 31; bit >= 0; bit--) {
            long countBitSet = 0;   // Count of numbers where current bit is set
            long countBitUnset = 0; // Count of numbers where current bit is not set
    
            // Check each number in the array
            for (long num : arr) {
                if ((num & (1 << bit)) != 0) {
                    countBitSet++;  // Bit is set at current position
                } else {
                    countBitUnset++; // Bit is not set at current position
                }
            }
    
            // Each pair with differing bits at current position contributes to XOR sum
            long differingPairs = countBitSet * countBitUnset;
    
            // The value contributed by these pairs at this bit position
            sum += differingPairs * (1L << bit);
        }
    
        return sum;
    }
}
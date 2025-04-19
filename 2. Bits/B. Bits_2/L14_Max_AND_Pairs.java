public class L14_Max_AND_Pairs {
    public static void main(String[] args) {
        int[] arr = { 4, 8, 12, 16 };
        System.out.println("The largest number of any pair is: " + maxAND(arr));
    }

    public static int maxAND(int[] arr) {
        int maxAND = 0;
        int n = arr.length;

        // Try to build the result bit by bit, from highest (30) to lowest (0)
        for (int bit = 30; bit >= 0; bit--) {
            int count = 0; // Count how many numbers in the array satisfy this bit pattern
            int temp = maxAND | (1 << bit); // Temporarily assume this bit can be part of max AND
            
            for (int i = 0; i < n; i++) {
                if ((arr[i] & temp) == temp) {
                    count++;
                }
            }

            // If two or more numbers match, keep this bit in the result
            if (count >= 2) {
                maxAND = temp;
            }
        }
        return maxAND;
    }
}
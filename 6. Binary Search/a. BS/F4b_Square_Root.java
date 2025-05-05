public class F4b_Square_Root {
    public static void main(String[] args) {
        System.out.println("The Integer Square root of 16 is: " + mySqrt(16));
        System.out.println("The Integer Square root of 82 is: " + mySqrt(82));
    }

    public static int mySqrt(int x) {
        int left = 0; // Start of binary search range
        int right = x; // End of binary search range

        // Binary search to find the integer part of the square root
        while (left <= right) {
            // Use long to avoid overflow when squaring
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid; // Exact square root found
            } else if (square > x) {
                right = (int) mid - 1; // Mid is too big, search left half
            } else {
                left = (int) mid + 1; // Mid is too small, search right half
            }
        }

        return right; // If no exact square root, return the floor of the square root
    }
}
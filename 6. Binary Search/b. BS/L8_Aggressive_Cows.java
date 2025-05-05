import java.util.Arrays;

public class L8_Aggressive_Cows {
    public static void main(String[] args) {
        int stalls[] = { 1, 2, 4, 8, 9 };
        int k = 3;
        System.out.println("Max possible of Min Distance: " + solve(k, stalls));

        int stalls1[] = { 10, 1, 2, 7, 5 };
        int k1 = 3;
        System.out.println("Max possible of Min Distance: " + solve(k1, stalls1));
    }

    // Function to find the largest minimum distance possible between k cows placed in the stalls
    public static int solve(int k, int[] stalls) {
        // Sort the stall positions to allow binary search over distances
        Arrays.sort(stalls);
        int n = stalls.length;

        int left = 1; // The minimum possible distance between cows is 1
        int right = stalls[n - 1] - stalls[0]; // The maximum is the difference between the last and first stall
        int result = 0;

        // Binary search for the largest minimum distance
        while (left <= right) {
            int mid = left + (right - left) / 2; // Mid represents a candidate for the minimum distance

            // If it's possible to place k cows with at least 'mid' distance apart
            if (canPlaceCows(stalls, mid) >= k) {
                result = mid; // Save the current distance
                left = mid + 1; // Try for a larger minimum distance
            } else {
                right = mid - 1; // Try for a smaller minimum distance
            }
        }
        return result;
    }

    // Helper function to count how many cows can be placed with at least 'mid' distance apart
    public static int canPlaceCows(int[] arr, int mid) {
        int cowsPlaced = 1; // Place the first cow in the first stall
        int lastPosition = arr[0]; // Track the last stall where a cow was placed

        for (int i = 1; i < arr.length; i++) {
            // Check if the current stall is at least 'mid' distance from the last cow
            if (arr[i] - lastPosition >= mid) {
                cowsPlaced++; // Place another cow
                lastPosition = arr[i]; // Update lastPosition to the current stall
            }
        }
        return cowsPlaced; // Return the number of cows that could be placed
    }
}
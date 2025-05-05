public class L6a_Ship_Packages {
    public static void main(String[] args) {
        int[] weights = { 10, 20, 30, 40 };
        int days = 2;
        System.out.println("Minimum shipping capacity: " + shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int weights[], int days) {
        int left = 0; // heaviest packages of all weights
        int right = 0; // total weight of all packages

        // Determine the heaviest package and the total weight of all packages
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right = right + weights[i];
        }

        // Try all possible capacities from maxPackage to totalWeight
        for (int i = left; i < right; i++) {
            if (calculateRequiredDays(weights, i) <= days) {
                return i; // Return the first valid (minimum) capacity
            }
        }
        return right; // Fallback (should never reach here)
    }

    // Helper method to determine how many days are needed to ship with a given
    // capacity
    public static int calculateRequiredDays(int[] weights, int capacity) {
        int dayCount = 1;
        int load = 0;

        for (int i = 0; i < weights.length; i++) {

            // If exceeds current capacity, increment day and reset load
            if (load + weights[i] > capacity) {
                dayCount++;
                load = 0; // Start a new shipment
            }
            load += weights[i];
        }
        return dayCount;
    }
}
public class L6b_Ship_Packages {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println("Minimum shipping capacity: " + shipWithinDays(arr, days));

        int arr1[] = { 3, 2, 2, 4, 1, 4 };
        int days1 = 3;
        System.out.println("Minimum shipping capacity: " + shipWithinDays(arr1, days1));

        int arr2[] = { 10, 20, 30, 40 };
        int days2 = 2;
        System.out.println("Minimum shipping capacity: " + shipWithinDays(arr2, days2));
    }

    public static int shipWithinDays(int weights[], int days) {
        int left = 0; // heaviest packages of all weights
        int right = 0; // total weight of all packages
        int result = 0; // Minimum capacity that can ship

        // Determine the heaviest package and the total weight of all packages
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        // Binary search between the heaviest package weight and the total weight
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if it's possible to ship with current capacity within given days
            if (calculate(weights, mid) <= days) {
                // Capacity is sufficient, try a smaller one to minimize
                result = mid;
                right = mid - 1;
            } else {
                // Capacity is not enough, increase it
                left = mid + 1;
            }
        }
        return result;
    }

    // Helper method to determine how many days are needed to ship with a given capacity
    public static int calculate(int[] weights, int mid) {
        int days = 1;
        int load = 0;

        for (int i = 0; i < weights.length; i++) {

            // If exceeds current capacity, increment day and reset load
            if (load + weights[i] > mid) {
                days++;
                load = 0; // Start a new shipment
            }
            load += weights[i];
        }

        return days;
    }
}
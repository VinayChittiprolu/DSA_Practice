public class L26a_SubArray_Bounded_maximum {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 3 };
        int left = 2;
        int right = 3;
        System.out.println("Total no. of Subarrays: " + numSubarrayBoundedMax(arr, left, right));
    }

    public static int numSubarrayBoundedMax(int arr[], int left, int right) {
        int count = 0;

        // Generate all subarrays
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i]; // Assume arr[i] is the max of the current subarray

            for (int j = i; j < arr.length; j++) {
                max = Math.max(max, arr[j]); // Update max for current subarray

                // Check if max is within range [left, right]
                if (max >= left && max <= right) {
                    count++;
                }
            }
        }
        return count;
    }
}
public class L16b_Median_of_2_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        System.out.println(findMedianSortedArrays(nums1, nums2));

        int[] nums_a = { 1, 2 };
        int[] nums_b = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums_a, nums_b));

        int[] a = { 1, 4, 7, 10, 12, 14 };
        int[] b = { 2, 3, 6, 15, 17, 19, 21 };
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length; // Length of the first array
        int m = nums2.length; // Length of the second array

        if (n > m) {
            return findMedianSortedArrays(nums2, nums1); // Recursively call to swapped arrays to simplify the binary search
        }

        int left = 0; // Lower bound for the binary search on nums1
        int right = n; // Upper bound for the binary search on nums1

        // Perform binary search on the smaller array (nums1)
        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = ((n + m) / 2) - mid1;

            // Determine the left and right boundaries of the partitions for both arrays
            // Handle edge cases where mid1 or mid2 might be 0 or equal to the array length
            int left1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE; // Left element of the left partition of nums1
            int right1 = (mid1 < n) ? nums1[mid1] : Integer.MAX_VALUE; // Right element of the left partition of nums1

            int left2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE; // Left element of the left partition of nums2
            int right2 = (mid2 < m) ? nums2[mid2] : Integer.MAX_VALUE; // Right element of the left partition of nums2

            // Check if the partitions are correctly formed
            if (left1 > right2) {
                // The left partition of nums1 has elements greater than the right partition of
                // nums2
                right = mid1 - 1; // Move the partition of nums1 to the left
            } else if (left2 > right1) {
                // The left partition of nums2 has elements greater than the right partition of
                // nums1
                left = mid1 + 1; // Move the partition of nums1 to the right
            } else {
                // The partitions are correctly formed, we can now calculate the median
                if ((n + m) % 2 == 0) {
                    // The median is the average of the two middle elements
                    return ((double) Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    // The median is the middle element
                    return Math.min(right1, right2);
                }
            }
        }
        return 0.0; // This should ideally not be reached if the logic is correct
    }
}
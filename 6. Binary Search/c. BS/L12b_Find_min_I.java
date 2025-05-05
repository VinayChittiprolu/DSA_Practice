public class L12b_Find_min_I {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums) + " is the smallest element as rotation point");

        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums1) + " is the smallest element as rotation point");

        int[] nums2 = { 11, 13, 15, 17 };
        System.out.println(findMin(nums2) + " is the smallest element as rotation point");
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1; // Variable to store the index of the minimum element found

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index in a safe way to avoid overflow

            // If the right half is sorted (including mid), the minimum must be on the left
            // side or at mid
            if (nums[mid] <= nums[right]) {
                // Update result if this is the first candidate or if it's smaller than the
                // previous one
                if (result == -1 || nums[mid] < nums[result]) {
                    result = mid;
                }
                right = mid - 1; // Continue searching in the left half
            } else {
                // Otherwise, the left half must be sorted, and the rotation point is on the
                // right
                if (result == -1 || nums[left] < nums[result]) {
                    result = left;
                }
                left = mid + 1; // Continue searching in the right half
            }
        }
        return nums[result]; // Return the smallest element found
    }
}
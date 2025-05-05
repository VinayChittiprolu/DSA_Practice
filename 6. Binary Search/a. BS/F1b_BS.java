public class F1b_BS {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(search(nums, target)); // TC: O(log n)

        int[] nums1 = { -1, 0, 3, 5, 9, 12 };
        int target1 = 2;
        System.out.println(search(nums1, target1));
    }

    public static int search(int[] nums, int target) {
        int left = 0; // Start of the search range
        int right = nums.length - 1; // End of the search range

        // Loop continues as long as the search range is valid
        while (left <= right) {
            int mid = left + (right - left) / 2; // Safer mid calculation

            // Check if the middle element is the target
            if (nums[mid] == target) {
                return mid; // Target found, return its index
            }
            // If the middle element is less than or equal to the target, search in the
            // right half
            else if (nums[mid] < target) {
                left = mid + 1; // Move the low pointer to mid + 1
            }
            // Otherwise, search in the left half
            else {
                right = mid - 1; // Move the high pointer to mid - 1
            }
        }

        // Target not found, return -1
        return -1;
    }
}
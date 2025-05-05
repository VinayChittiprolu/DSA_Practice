public class L10b_Search_Rotated_Sorted_Array_I {
    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println("Target is at index: " + search(nums, target));

        int nums1[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 3;
        System.out.println("Target is at index: " + search(nums1, target1));
    }

    public static int search(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        // Standard binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // If the mid element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the right half is sorted
            if (nums[mid] <= nums[right]) {
                // If the target is within the sorted right half
                if (target <= nums[right] && target >= nums[mid]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Otherwise, search in the left half
                }
            }
            // Else, the left half must be sorted
            else {
                // If the target is within the sorted left half
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Otherwise, search in the right half
                }
            }
        }
        return -1; // Target not found
    }
}
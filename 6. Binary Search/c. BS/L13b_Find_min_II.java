public class L13b_Find_min_II {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        System.out.println(findMin(nums) + " is the smallest element as rotation point");

        int[] nums1 = { 2, 2, 2, 0, 1 };
        System.out.println(findMin(nums1) + " is the smallest element as rotation point");
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Handle the case where the middle element is equal to elements on both sides.
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                if (result == -1 || nums[left] < nums[result]) {
                    result = mid; // If all elements are the same, any element can be considered the minimum.
                }
                left++;
                right--;
            }
            // Explore both halves if the middle element is not the minimum.
            else if (nums[mid] <= nums[right]) {
                // right half is sorted
                if (result == -1 || nums[mid] < nums[result]) {
                    result = mid;
                }
                right = mid - 1;
            } else {
                // left half is sorted
                if (result == -1 || nums[left] < nums[result]) {
                    result = left;
                }
                left = mid + 1;
            }
        }
        return nums[result];
    }
}
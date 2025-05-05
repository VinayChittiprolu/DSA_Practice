public class L12c_Find_Min_I {
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

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost, min is to the right
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid; // Minimum is in the left half including mid
            }
        }

        return nums[left]; // When loop ends, left == right, pointing to the minimum
    }
}
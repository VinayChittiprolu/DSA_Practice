public class L13c_Find_Min_II {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        System.out.println(findMin(nums) + " is the smallest element as rotation point");

        int[] nums1 = { 2, 2, 2, 0, 1 };
        System.out.println(findMin(nums1) + " is the smallest element as rotation point");
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
public class L12a_Find_Min_I {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums) + " is the smallest element as rotation point");

        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums1) + " is the smallest element as rotation point");

        int[] nums2 = { 11, 13, 15, 17 };
        System.out.println(findMin(nums2) + " is the smallest element as rotation point");
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int min = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
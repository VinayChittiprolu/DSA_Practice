public class L10a_Search_Rotated_Array_I {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        System.out.println("Target is at index: " + search(nums, target));
    }

    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i; // Target found
            }
        }
        return -1; // Target not found
    }
}
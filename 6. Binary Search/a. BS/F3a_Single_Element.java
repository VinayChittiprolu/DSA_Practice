public class F3a_Single_Element {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println("Single non-duplicate element is: " + singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Edge case: if only one element
        if (n == 1) {
            return nums[0];
        }
        
        // Check first element
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[n - 1];// Check last element
    }
}
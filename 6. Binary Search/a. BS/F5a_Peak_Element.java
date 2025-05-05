public class F5a_Peak_Element {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1 };
        System.out.println("The peak element is at index: " + findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean left = (i == 0) || (nums[i] > nums[i - 1]);
            boolean right = (i == n - 1) || (nums[i] > nums[i + 1]);

            if (left && right) {
                return i; // nums[i] is a peak
            }
        }
        return -1; // Should not happen, as a peak is guaranteed to exist
    }
}
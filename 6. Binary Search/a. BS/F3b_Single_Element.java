public class F3b_Single_Element {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println("Single non-duplicate element is: " + singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int high = nums.length - 1;

        // Binary search loop
        while (left < high) {
            int mid = left + (high - left) / 2; // Find the middle index

            // Check if the mid element is part of a pair
            if (nums[mid] == nums[mid + 1]) {
                // If mid and mid + 1 are equal, check the parity of mid
                if (mid % 2 == 0) {
                    left = mid + 2; // If mid is even, the single element is after mid + 1
                } else {
                    high = mid - 1; // If mid is odd, the single element is before mid
                }
            } else if (nums[mid] == nums[mid - 1]) { // If mid and mid - 1 are equal
                if (mid % 2 == 0) {
                    high = mid - 2; // If mid is even, the single element is before mid
                } else {
                    left = mid + 1; // If mid is odd, the single element is after mid
                }
            } else {
                return nums[mid]; // If mid is not equal to its neighbors, mid is the single element
            }
        }

        return nums[left]; // After the loop, low == high and points to the single element
    }
}
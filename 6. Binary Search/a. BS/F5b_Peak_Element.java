public class F5b_Peak_Element {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println("The peak element is at index: " + findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // Continue the loop until the search space narrows to a single element
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is less than the next element, move right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // Otherwise, move left (or stay at mid)
                right = mid;
            }
        }

        return left; // left == right is the peak index
    }
}
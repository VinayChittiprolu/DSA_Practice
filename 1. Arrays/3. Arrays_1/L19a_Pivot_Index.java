public class L19a_Pivot_Index {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 3, 6, 5, 6 };
        System.out.println("Pivot Index: " + findPivotIndex(arr));
    }

    public static int findPivotIndex(int[] nums) {
        // Iterate through each index and calculate the left and right sums
        for (int i = 0; i < nums.length; i++) {
           
            int leftSum = 0;
            for (int p = 0; p < i; p++) { // Calculate the left sum
                leftSum += nums[p];
            }
            
            int rightSum = 0;
            for (int q = i + 1; q < nums.length; q++) { // Calculate the right sum
                rightSum += nums[q];
            }

            if (leftSum == rightSum) { // Check if the left and right sums are equal
                return i; // Return the pivot index
            }
        }

        return -1;// If no pivot index is found, return -1
    }
}
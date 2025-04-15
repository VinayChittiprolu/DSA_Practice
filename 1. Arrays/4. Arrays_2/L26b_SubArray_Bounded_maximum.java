public class L26b_SubArray_Bounded_maximum {
   public static void main(String[] args) {
      int arr[] = { 2, 1, 4, 3 };
      int left = 2;
      int right = 3;
      System.out.println(numSubarrayBoundedMax(arr, left, right));
   }

   public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
      int ans = 0;
      int rightVal = -1; // The index where the element exceeds 'right'
      int leftVal = -1; // The index where the element is greater than or equal to 'left'

      for (int i = 0; i < nums.length; ++i) {
         // Reset if the current element is greater than 'right'
         if (nums[i] > right) {
            rightVal = i;
         }
         // Update if the current element is valid (>= 'left')
         if (nums[i] >= left) {
            leftVal = i;
         }
         // Add the number of valid subarrays ending at 'i'
         ans += leftVal - rightVal;
      }

      return ans;
   }
}
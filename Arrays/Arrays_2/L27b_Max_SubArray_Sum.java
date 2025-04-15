public class L27b_Max_SubArray_Sum {
   public static void main(String[] args) {
      int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
      System.out.println("largest sum is: " + maxSubArray(arr));
   }

   public static int maxSubArray(int[] nums) {
      int currentSum = 0;
      int maxSum = Integer.MIN_VALUE;

      for (int i = 0; i < nums.length; i++) {
         if (currentSum >= 0) {
            currentSum += nums[i];
         } else {
            currentSum = nums[i];
         }
         maxSum = Math.max(currentSum, maxSum);
      }

      return maxSum;
   }
}
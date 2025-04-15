public class L28b_Max_product_Subarray {
   public static void main(String[] args) {
      int arr[] = { 2, 3, -2, 4 };
      System.out.println("Maximum Product of Subarray is: " + maxProduct(arr));
   }

   public static int maxProduct(int[] nums) {
      int globalMax = Integer.MIN_VALUE;
      int n = nums.length;

      int prefix = 1;
      for (int i = 0; i < n; i++) {
         if (prefix == 0) {
            prefix = nums[i];
         } else {
            prefix = prefix * nums[i];
         }
         globalMax = Math.max(globalMax, prefix);
      }

      int suffix = 1;
      for (int i = n - 1; i >= 0; i--) {
         if (suffix == 0) {
            suffix = nums[i];
         } else {
            suffix = suffix * nums[i];
         }
         globalMax = Math.max(globalMax, suffix);
      }

      return globalMax;
   }
}
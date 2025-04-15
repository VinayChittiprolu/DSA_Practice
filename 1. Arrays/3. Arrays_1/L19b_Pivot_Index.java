public class L19b_Pivot_Index {
   public static void main(String[] args) {
      int[] arr = { 1, 7, 3, 6, 5, 6 };
      System.out.println("Pivot Index: " + findPivotIndex(arr));
   }

   public static int findPivotIndex(int[] nums) {
      int totalSum = 0;
      for (int i = 0; i < nums.length; i++) { // Calculate the total sum of the array
         totalSum = totalSum + nums[i];
      }
      
      int leftSum = 0;
      for (int i = 0; i < nums.length; i++) { // Iterate through the array to find the pivot index
         if (leftSum == totalSum - leftSum - nums[i]) {
            return i;
         } else {
            leftSum = leftSum + nums[i];
         }
      }
      return -1;
   }
}
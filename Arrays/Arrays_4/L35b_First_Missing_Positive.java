public class L35b_First_Missing_Positive {
   public static void main(String[] args) {
      int arr[] = { 7, 8, 9, 11, 12 };
      int arr2[] = { 3, 4, -1, 1 };
      int arr3[] = { 1, 2, 3, 3, 4, 5, 6 };

      System.out.println("Missing number is: " + firstMissingPositive(arr));
      System.out.println("Missing number is: " + firstMissingPositive(arr2));
      System.out.println("Missing number is: " + firstMissingPositive(arr3));
   }

   public static int firstMissingPositive(int[] nums) {
      int n = nums.length; // Length of the array

      // Step 1: Place each number at its correct index if possible
      for (int i = 0; i < n; i++) {
         while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
            int temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
         }
      }

      // Step 2: Find the first missing positive integer
      for (int i = 0; i < n; i++) {
         if (nums[i] != i + 1) {
            return i + 1;
         }
      }
      return n + 1; // If all numbers are in place, return the next positive integer
   }
}
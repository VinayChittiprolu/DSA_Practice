import java.util.Arrays;

public class L18a_Range_Sum_Query {

   public static void main(String[] args) {
      int[] nums = { 1, 2, 3, 4, 5, 6 };
      int left = 1;
      int right = 5;

      int[] sum = runningSum(nums);
      System.out.println(Arrays.toString(sum)); // Array of runningSum.

      if (left == 0) {
         System.out.println(sum[right]);
      } else {
         System.out.println(sum[right] - sum[left - 1]);
      }
   }

   public static int[] runningSum(int arr[]) {
      int[] prefix = new int[arr.length]; // Initialize a new array to store the prefix sums

      // Iterate over each element in the input array
      for (int i = 0; i < arr.length; i++) {
         // If it's the first element, the prefix sum is the element itself
         if (i == 0) {
            prefix[i] = arr[i];
         } else {
            // For subsequent elements, add the current element to the previous prefix sum
            prefix[i] = prefix[i - 1] + arr[i];
         }
      }
      return prefix;
   }
}
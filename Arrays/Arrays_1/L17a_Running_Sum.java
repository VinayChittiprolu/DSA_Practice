import java.util.Arrays;

public class L17a_Running_Sum {
   public static void main(String[] args) {
      int arr[] = { 1, 1, 1, 1, 1 };
      int summ_arr[] = runningSum(arr);

      System.out.println(Arrays.toString(summ_arr));
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
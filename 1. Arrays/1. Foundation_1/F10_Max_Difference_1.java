public class F10_Max_Difference_1 {
   public static void main(String[] args) {
      int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

      System.out.println(maxDiff(arr));
   }

   public static int maxDiff(int[] arr) {
      int max = Integer.MIN_VALUE; // Initialize max to the smallest possible integer value
      int min = Integer.MAX_VALUE; // Initialize min to the largest possible integer value

      // Iterate through each element in the array
      for (int i = 0; i < arr.length; i++) {
         // Update max if the current element is greater than the current max
         if (arr[i] > max) {
            max = arr[i];
         }
         // Update min if the current element is smaller than the current min
         if (arr[i] < min) {
            min = arr[i];
         }
      }
      return max - min; // Return the difference between the maximum and minimum values found
   }
}
public class F3_Count_Greater {
   public static void main(String[] args) {
      int arr[] = { -4, -3, 7, 9, 3, 9, 4 };
      System.out.println(maxCount(arr));
   }

   public static int maxCount(int arr[]) {
      int n = arr.length; // Get the length of the array

      // Initialize max_val to the smallest possible integer value
      int max_val = Integer.MIN_VALUE;

      // Find the maximum value in the array
      for (int i = 0; i < n; i++) {
         if (arr[i] > max_val) {
            max_val = arr[i]; // Update max_val if a larger value is found
         }
      }

      int max_count = 0; // Initialize a counter to keep track of occurrences of the maximum value

      // Count how many times the maximum value appears in the array
      for (int i = 0; i < n; i++) {
         if (max_val == arr[i]) {
            max_count++; // Increment the counter if the current element equals max_val
         }
      }
      // Subtract the count of the maximum value from the total number of elements and return
      return n - max_count;
   }
}
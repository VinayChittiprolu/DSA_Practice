public class F11_b_Max_Difference_2 {
   public static void main(String[] args) {
      int arr[] = { 3, 9, 8, 4, 1 };

      System.out.println(differenceMaxMin(arr));
   }

   public static int differenceMaxMin(int[] arr) {
      if (arr == null || arr.length == 0) {
         return 0;
      }

      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;

      for (int i = 0; i < arr.length; i++) {
         arr[i] = arr[i] + i; // Modify the current element by adding its index.

         max = Math.max(max, arr[i]); // Update max if the current element is greater than the current max.
         min = Math.min(min, arr[i]); // Update min if the current element is less than the current min.
      }

      return max - min;
   }
}
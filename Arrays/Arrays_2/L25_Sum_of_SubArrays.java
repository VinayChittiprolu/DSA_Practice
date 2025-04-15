public class L25_Sum_of_SubArrays {
   public static void main(String[] args) {
      int[] arr = { 5, 3, -1, 8 };
      int n = arr.length;
      System.out.println("Sum of Subarrays is: " + sum_of_subarray(arr, n));
   }

   public static int sum_of_subarray(int arr[], int n) {
      int sum = 0;

      for (int i = 0; i < n; i++) {
         sum += arr[i] * (i + 1) * (n - i);
      }

      return sum;
   }
}
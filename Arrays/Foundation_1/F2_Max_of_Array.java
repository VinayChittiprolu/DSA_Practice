public class F2_Max_of_Array {
   public static void main(String[] args) {
      int arr[] = { 7, -10, 1, 31, 9, 20 };
      System.out.println("The Maximum value is: " + maxValue(arr));
   }

   public static int maxValue(int[] arr) {
      int max_val = Integer.MIN_VALUE;

      for (int i = 0; i < arr.length; i++) {
         if (arr[i] > max_val) {
            max_val = arr[i];
         }
      }

      return max_val;
   }
}
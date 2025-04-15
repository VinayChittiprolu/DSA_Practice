import java.util.Arrays;

public class F4_swap_index {
   public static void main(String[] args) {
      int arr[] = { 31, 4, -7, 1, -29 };
      int x = 1;
      int y = 4;
      
      swap(arr, x, y);
      System.out.println(Arrays.toString(arr));  // Print the array

      // Print the array properly
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
   }

   public static void swap(int arr[], int x, int y) {
      int temp = arr[x];
      arr[x] = arr[y];
      arr[y] = temp;
   }
}
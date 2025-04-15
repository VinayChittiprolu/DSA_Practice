import java.util.Arrays;

public class F6_reverse_the_array {
   public static void main(String[] args) {
      int arr[] = { 1, 2, 3, 6, 12 };

      reverseArray(arr, 0, arr.length - 1);
      System.out.println(Arrays.toString(arr));
   }

   public static void reverseArray(int[] arr, int sp, int ep) {
      // Continue looping until the starting pointer (sp) crosses the ending pointer (ep)
      while (sp < ep) {
         // Swap the elements at the start and end pointers
         int temp = arr[sp]; // Store the element at the start pointer in a temporary variable
         arr[sp] = arr[ep]; // Assign the element at the end pointer to the start pointer
         arr[ep] = temp; // Assign the stored element (temp) to the end pointer

         // Move the pointers towards the center
         sp++; // Increment the start pointer
         ep--; // Decrement the end pointer
      }
   }
}
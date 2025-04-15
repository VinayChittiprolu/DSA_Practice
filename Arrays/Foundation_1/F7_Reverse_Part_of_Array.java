
import java.util.*;

public class F7_Reverse_Part_of_Array {
   public static void main(String[] args) {
      int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

      reversePart(arr, 0, 3);
      System.out.println(Arrays.toString(arr));
   }

   public static void reversePart(int[] arr, int sp, int ep) {
      // Continue looping until the starting pointer(sp) crosses the ending
      // pointer(ep)
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
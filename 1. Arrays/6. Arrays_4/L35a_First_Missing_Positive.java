import java.util.Arrays;

public class L35a_First_Missing_Positive {
   public static void main(String[] args) {
      int arr[] = { 7, 8, 9, 11, 12 };
      int arr2[] = { 3, 4, -1, 1 };
      int arr3[] = { 1, 2, 3, 3, 4, 5, 6 };

      System.out.println("Missing number is: " + firstMissingPositive(arr));
      System.out.println("Missing number is: " + firstMissingPositive(arr2));
      System.out.println("Missing number is: " + firstMissingPositive(arr3));
   }

   public static int firstMissingPositive(int[] nums) {
      Arrays.sort(nums); // Step 1: Sort the array
      int smallestPositive = 1; // Start checking from 1

      // Step 2: Iterate through sorted array using traditional for-loop
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] == smallestPositive) {
            smallestPositive++; // Move to the next expected positive number
         }
      }

      return smallestPositive; // The first missing positive
   }
}
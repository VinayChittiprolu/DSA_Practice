import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class L37a_Majority_Element_2 {
   public static void main(String[] args) {
      int[] nums = { 1, 1, 2, 3, 4, 1, 1, 5, 6, 7, 1, 1, 8, 9, 10, 1, 11, 12, 13, 14 };
      int[] nums2 = { 3, 2, 3 };

      List<Integer> result = majorityElement(nums);
      System.out.println(result);

      List<Integer> result2 = majorityElement(nums2);
      System.out.println(result2);
   }

   public static List<Integer> majorityElement(int[] nums) {
      Arrays.sort(nums); // Sort the array to group identical elements together
      int n = nums.length; 

      List<Integer> result = new ArrayList<>(); // List to store the result
      int count = 1; // Initialize count for the first element

      // Iterate through the sorted array to count occurrences
      for (int i = 1; i < n; i++) {
         if (nums[i] == nums[i - 1]) {
            count++; // Increment count if the same element appears consecutively
         } else {
            if (count > n / 3) { // If count exceeds n/3, add the element to the result list
               result.add(nums[i - 1]);
            }
            count = 1; // Reset count for the next unique element
         }
      }

      // Check the last element group after the loop ends
      if (count > n / 3) {
         result.add(nums[n - 1]);
      }

      return result;
   }
}
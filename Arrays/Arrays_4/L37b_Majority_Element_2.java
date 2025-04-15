import java.util.ArrayList;
import java.util.List;

public class L37b_Majority_Element_2 {
   public static void main(String[] args) {
      int[] nums = { 1, 1, 2, 3, 4, 1, 1, 5, 6, 7, 1, 1, 8, 9, 10, 1, 11, 12, 13, 14 };
      int[] nums2 = { 3, 2, 3 };

      List<Integer> result = majorityElement(nums);
      System.out.println(result);

      List<Integer> result2 = majorityElement(nums2);
      System.out.println(result2);
   }

   public static List<Integer> majorityElement(int nums[]) {
      // Variables to store the potential majority elements and their respective
      // counts
      int candidate1 = 0, candidate2 = 0;
      int count1 = 0, count2 = 0;

      // First pass: Find potential candidates for majority elements
      for (int i = 0; i < nums.length; i++) {
         if (count1 == 0 && candidate2 != nums[i]) {
            candidate1 = nums[i];
         } else if (count2 == 0 && candidate1 != nums[i]) {
            candidate2 = nums[i];
         }

         if (candidate1 == nums[i]) {
            count1++;
         } else if (candidate2 == nums[i]) {
            count2++;
         } else {
            count1--;
            count2--;
         }
      }

      // Second pass: Verify if the candidates appear more than n/3 times
      count1 = 0;
      count2 = 0;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] == candidate1) {
            count1++;
         } else if (nums[i] == candidate2) {
            count2++;
         }
      }

      // Store the valid majority elements in the result list
      List<Integer> result = new ArrayList<>();
      if (count1 > nums.length / 3) {
         result.add(candidate1);
      }
      if (count2 > nums.length / 3) {
         result.add(candidate2);
      }
      return result;
   }
}
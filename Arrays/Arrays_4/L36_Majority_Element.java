public class L36_Majority_Element {
   public static void main(String[] args) {
      int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
      int nums1[] = { 3, 2, 3 };
      int nums2[] = { 5, 2, 3, 3, 3 };

      System.out.println("String" + MajorityElement(nums));
      System.out.println(MajorityElement(nums1));
      System.out.println(MajorityElement(nums2));
   }

   public static int MajorityElement(int nums[]) {
      int candidate = 0; // Potential majority element
      int votes = 0; // Vote count for the candidate

      for (int i = 0; i < nums.length; i++) {
         if (votes == 0) {
            candidate = nums[i]; // Set a new candidate
         }
         if (nums[i] == candidate) {
            votes++; // Increase votes for the candidate
         } else {
            votes--; // Decrease votes if different
         }
      }

      return candidate; // Candidate is the majority element
   }
}
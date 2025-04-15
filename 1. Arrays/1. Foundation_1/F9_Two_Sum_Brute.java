public class F9_Two_Sum_Brute {
   public static void main(String[] args) {
      int arr1[] = { 1, 2, 3, 4, 5, 6, 7 };
      int arr2[] = { -1, -2, 3, 4, -5, 6, 7 };
      int k = 8;

      System.out.println(twoSum(arr1, k));
      System.out.println(twoSum(arr2, k));
   }

   public static boolean twoSum(int[] arr, int k) {
      int n = arr.length; // Get the length of the array

      // Iterate over each element in the array (outer loop)
      for (int i = 0; i < n; i++) {
         // Iterate over the elements that come after arr[i] (inner loop)
         for (int j = i + 1; j < n; j++) {
            // Check if the sum of arr[i] and arr[j] equals k
            if (arr[i] + arr[j] == k) {
               return true; // If a pair is found, return true immediately
            }
         }
      }

      // If no pair is found after both loops, return false
      return false;
   }
}
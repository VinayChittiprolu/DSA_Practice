public class F5_largest_num {
   public static void main(String[] args) {
      int arr1[] = { 6, 2, 3, 1 };
      int arr2[] = { 1, 2, 4, 7, 12 };

      System.out.println("The largest number is at index of: " + largestNumber(arr1));
      System.out.println("The largest number is at index of: " + largestNumber(arr2));
   }

   public static int largestNumber(int[] arr) {
      // Initialize variables to track the largest and second largest values
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;
      int index = 0; // Tracks the index of the largest value

      // Iterate through the array to find the two largest numbers
      for (int i = 0; i < arr.length; i++) {
         // If the current element is greater than the largest found so far
         if (arr[i] > max1) {
            max2 = max1; // Update second largest to the previous largest
            max1 = arr[i]; // Update the largest to the current element
            index = i; // Store the index of the largest element
         }
         // If the current element is not the largest but is greater than the second largest
         else if (arr[i] > max2) {
            max2 = arr[i]; // Update the second largest
         }
      }

      // Check if the largest value is at least twice as large as the second largest
      if (max2 * 2 <= max1) {
         return index; // Return the index of the largest element
      } else {
         return -1; // Return -1 if no such element exists
      }
   }
}
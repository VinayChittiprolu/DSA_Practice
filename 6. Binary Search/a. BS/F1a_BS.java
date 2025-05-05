public class F1a_BS {
    public static void main(String[] args) {
        int[] numbers = { 2, 4, 6, 8, 10, 12, 14 };
        int target = 10;

        int result = search(numbers, target); // TC: O(n)

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }
    }

    // Method to perform a simple linear search
    public static int search(int[] nums, int target) {
        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element matches the target
            if (nums[i] == target) {
                return i; // Target found, return its index
            }
        }

        return -1; // If loop completes and no match is found
    }
}
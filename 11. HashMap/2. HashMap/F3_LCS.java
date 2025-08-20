import java.util.HashSet;

public class F3_LCS {
    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(arr));

        int[] arr1 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(arr1));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the HashSet for O(1) lookups
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // Variable to keep track of the maximum length of consecutive sequences
        int maxLength = 0;

        // Iterate through each number in the set
        for (int num : set) {
            // Only check for the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num; // Start of a new sequence
                int currentStreak = 1; // Initialize the current streak length

                // Count the length of the consecutive sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                maxLength = Math.max(maxLength, currentStreak);
            }
        }

        return maxLength;
    }
}
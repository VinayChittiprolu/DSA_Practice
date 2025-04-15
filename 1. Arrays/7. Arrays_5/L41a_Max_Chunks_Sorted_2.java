public class L41a_Max_Chunks_Sorted_2 {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        System.out.println("The largest number of chunks is: " + maxChunksToSorted(arr));

        int[] arr2 = { 2, 1, 3, 4, 4 };
        System.out.println("The largest number of chunks is: " + maxChunksToSorted(arr2));
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Iterate through the array to determine valid chunk splits
        for (int i = 0; i < n; i++) {
            // boolean canSplit = true;

            // Get the max value in the left partition (0 to i)
            int leftMax = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            // Get the min value in the right partition (i+1 to n-1)
            int rightMin = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                rightMin = Math.min(rightMin, arr[j]);
            }

            // Check if a valid split can be made
            if (leftMax <= rightMin) {
                count++;
            }
        }
        return count;
    }
}
public class L41b_Max_Chunks_Sorted_2 {
	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1 };
		System.out.println("The largest number of chunks is: " + maxChunksToSorted(arr));

		int[] arr2 = { 2, 1, 3, 4, 4 };
		System.out.println("The largest number of chunks is: " + maxChunksToSorted(arr2));
	}

	public static int maxChunksToSorted(int[] arr) {
		int n = arr.length;

		// Create an array to store the maximum value seen so far from the left
		int[] leftMax = new int[n];
		leftMax[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}

		// Create an array to store the minimum value seen so far from the right
		int[] rightMin = new int[n];
		rightMin[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
		}

		int count = 0;

		// Count valid partitions where the maximum in the left part is less than or equal to the minimum in the right part
		for (int i = 0; i < n - 1; i++) {
			if (leftMax[i] <= rightMin[i + 1]) {
				count++;
			}
		}

		return count + 1; // The last chunk (remaining elements) should always be counted
	}
}
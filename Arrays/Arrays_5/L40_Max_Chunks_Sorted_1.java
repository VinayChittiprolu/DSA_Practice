public class L40_Max_Chunks_Sorted_1 {
	public static void main(String[] args) {
		int arr[] = { 4, 3, 2, 1, 0 };
		System.out.println("The largest number of chunks is: " + MaxChunksSorted1(arr));

		int arr2[] = { 1, 0, 2, 3, 4 };
		System.out.println("The largest number of chunks is: " + MaxChunksSorted1(arr2));
	}

	public static int MaxChunksSorted1(int arr[]) {
		int count = 0; // Variable to keep track of the number of chunks
		int maxValue = 0; // Variable to store the maximum value encountered so far in the array

		// Iterate through the array
		for (int i = 0; i < arr.length; i++) {
			maxValue = Math.max(maxValue, arr[i]); // Update maxValue with the maximum value encountered so far

			// If maxValue matches the current index, it means we can form a chunk
			if (maxValue == i) {
				count++; // Increment the chunk count
			}
		}

		return count; // Return the total number of chunks
	}
}
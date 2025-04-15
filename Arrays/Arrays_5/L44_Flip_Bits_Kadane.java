public class L44_Flip_Bits_Kadane {
	public static void main(String[] args) {
		int[] matrix = { 1, 0, 0, 1, 0 };
		int[] matrix_2 = { 1, 0, 0, 1, 0, 0, 1 };

		System.out.println("Total no of bits flipped: " + flipBits(matrix));
		System.out.println("Total no of bits flipped: " + flipBits(matrix_2));
	}

	public static int flipBits(int[] arr) {
		int count = 0; // Count of 1s in the original array
		int currentDiff = 0; // Tracks the difference when flipping 0s to 1s
		int maxDiff = 0; // Maximum difference encountered

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				count++; // Count the number of 1s in the original array
				currentDiff = Math.max(0, currentDiff - 1); // Decrease difference when encountering 1
			} else {
				currentDiff = Math.max(0, currentDiff + 1); // Increase difference when encountering 0 greater
			}
		}
		return count + maxDiff; // The result is the total count of 1s plus the maximum difference from flipping subarray
	}
}
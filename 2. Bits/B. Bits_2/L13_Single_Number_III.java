import java.util.Arrays;

public class L13_Single_Number_III {
	public static void main(String[] args) {
		int[] arr = { 10, 8, 8, 9, 12, 9, 6, 11, 10, 6, 12, 21 };
		int result[] = singleNumber(arr);
		System.out.println("Result: " + Arrays.toString(result));

		int arr1[] = { 1, 2, 1, 3, 2, 5 };
		int result1[] = singleNumber(arr1);
		System.out.println("Result: " + Arrays.toString(result1));
	}

	public static int[] singleNumber(int nums[]) {
		// Step 1: Perform XOR operation on all elements of the array
		int xorResult = 0;
		for (int i = 0; i < nums.length; i++) {
			xorResult = xorResult ^ nums[i]; // since duplicates cancel out
		}

		// Step 2: Find the rightmost set bit in the xorResult
		int index = 0;
		for (int i = 0; i < 32; i++) {
			if (isBitSet(xorResult, i) == true) {
				index = i;
				break;
			}
		}

		// Step 3: Separate the numbers based on the rightmost set bit
		int setBits = 0;
		int unSetBits = 0;
		for (int i = 0; i < nums.length; i++) {
			if (isBitSet(nums[i], index) == true) {
				unSetBits = unSetBits ^ nums[i]; // Group with bit set
			} else {
				setBits = setBits ^ nums[i]; // Group with bit not set
			}
		}

		// setBits and unSetBits are the two non-repeating numbers
		return new int[] { setBits, unSetBits };
	}

	// Helper method to check if the bit at a given index is set (1) in a number
	public static boolean isBitSet(int n, int i) {
		return (n & (1 << i)) != 0;
	}
}
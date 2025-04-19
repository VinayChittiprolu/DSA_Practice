public class L9_Single_Number_II {
	public static void main(String[] args) {
		int arr[] = { 2, 2, 3, 2 };
		System.out.println("The single number in an array: " + singleNumber(arr));

		int arr1[] = { 0, 1, 0, 1, 0, 1, 99 };
		System.out.println("The single number in an array: " + singleNumber(arr1));
	}

	public static int singleNumber(int[] nums) {
		int seen1 = 0; // Tracks bits that have appeared once
		int seen2 = 0; // Tracks bits that have appeared thrice

		for (int i = 0; i < nums.length; i++) {
			// 'seen1' becomes 1 only if 'numbers[i]' is 1 and 'seen2' is 0
			seen1 = (seen1 ^ nums[i]) & ~seen2;
			// 'seen2' becomes 1 only if 'numbers[i]' is 1 and 'seen1' was 0 (before the
			// update)
			seen2 = (seen2 ^ nums[i]) & ~seen1;
		}
		return seen1;
	}
}
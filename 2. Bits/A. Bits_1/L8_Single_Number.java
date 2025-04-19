public class L8_Single_Number {
	public static void main(String[] args) {
		int arr[] = { 2, 2, 1 };
		System.out.println(singleNumber(arr));

		int arr1[] = { 4, 1, 2, 1, 2 };
		System.out.println(singleNumber(arr1));

		int arr2[] = { 1 };
		System.out.println(singleNumber(arr2));
	}

	public static int singleNumber(int[] nums) {
		int ans = 0;

		for (int i = 0; i < nums.length; i++) {
			ans = ans ^ nums[i];
		}

		return ans;
	}
}
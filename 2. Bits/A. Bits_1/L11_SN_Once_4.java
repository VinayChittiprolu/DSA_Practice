public class L11_SN_Once_4 {
	public static void main(String[] args) {
		int arr[] = { 3, 2, 2, 3, 1, 2, 3, 3, 2 }; // 1
		System.out.println(singleNumber(arr));
	}

	public static int singleNumber(int[] nums) {
		int ans = 0;

		for (int i = 0; i < 32; i++) {
			int count = 0;

			// Count how many numbers have the i-th bit set
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & (1 << i)) != 0) {
					count++;
				}
			}

			// If the count % 4 is 1, it means the bit is set in the result number
			if (count % 4 == 1) {
				ans = ans + (1 << i); // Set the i-th bit in the final answer
			}
		}
		return ans;
	}
}
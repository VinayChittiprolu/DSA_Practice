public class L7_Count_UnSet_Bits {
	public static void main(String[] args) {
		int n = 6;
		System.out.println("Total no of unSet Bits: " + unSetBits(n));

		int n1 = 15;
		System.out.println("Total no of unSet Bits: " + unSetBits(n1));
	}

	public static int unSetBits(int n) {
		int count = 0;
		for (int k = 0; k < 32; k++) {
			if (((n & (1 << k)) == 0)) {
				count++;
			}
		}
		return count;
	}
}
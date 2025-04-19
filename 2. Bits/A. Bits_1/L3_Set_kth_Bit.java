public class L3_Set_kth_Bit {
	public static void main(String[] args) {
		int n = 10;
		int k = 2;
		System.out.println("Set kth Bit is: " + bitSet(n, k));

		int n1 = 2;
		int k1 = 0;
		System.out.println("Set kth Bit is: " + bitSet(n1, k1));
	}

	public static int bitSet(int n, int k) {
		int ans = n | (1 << k);
		return ans;
	}
}
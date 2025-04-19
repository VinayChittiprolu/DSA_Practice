public class L5_UnSet_kth_Bit {
	public static void main(String[] args) {
		int n = 15;
		int k = 1;
		System.out.println("UnSet kth Bit is: " + bitUnset(n, k));

		int n1 = 2;
		int k1 = 0;
		System.out.println("UnSet kth Bit is: " + bitUnset(n1, k1));
	}

	public static int bitUnset(int n, int k) {
		int ans = n & ~(1 << k);
		return ans;
	}
}
public class L4_Toggle_kth_Bit {
	public static void main(String[] args) {
		int n = 75;
		int k = 4;
		System.out.println(toggleBit(n, k));

		int n1 = 5;
		int k1 = 1;
		System.out.println(toggleBit(n1, k1));
	}

	public static int toggleBit(int n, int k) {
		int ans = n ^ (1 << k);
		return ans;
	}
}
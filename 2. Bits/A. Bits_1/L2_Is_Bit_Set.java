public class L2_Is_Bit_Set {
	public static void main(String[] args) {
		int n = 4;
		int k = 0;
		System.out.println(isBitSet(n, k));

		int n1 = 4;
		int k1 = 2;
		System.out.println(isBitSet(n1, k1));
	}

	public static boolean isBitSet(int n, int k) {
		return ((n & (1 << k)) != 0);
	}
}
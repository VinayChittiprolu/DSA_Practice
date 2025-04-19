public class L6_Count_Set_Bits {
	public static void main(String[] args) {
		int n = 5;
		System.out.println("Total no of set Bits: " + setBits(n));

		int n1 = 15;
		System.out.println("Total no of set Bits: " + setBits(n1));
	}

	public static int setBits(int n) {
		int count = 0;
		for (int k = 0; k < 32; k++) {
			if (((n & (1 << k)) != 0)) {
				count++;
			}
		}
		return count;
	}
}
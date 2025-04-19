import java.util.Scanner;

public class F1_Is_Even {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.print("Enter the number n: ");
		int n = scn.nextInt();

		if ((n & 1) == 0) {
			System.out.println(n + " is an 'Even' number");
		} else {
			System.out.println(n + " is an 'Odd' number");
		}
		scn.close();
	}
}
public class L15_Division_Two_Integers {
	public static void main(String[] args) {
		int dividend = -1;
		int divisor = -1;

		System.out.println(divide(dividend, divisor));
	}

	public static int divide(int dividend, int divisor) {
		// Determine the sign of the result.
		int sign = 1;
		if (dividend < 0) {
			sign = sign * -1;
		}
		if (divisor < 0) {
			sign = sign * -1;
		}

		// Convert dividend and divisor to long to handle potential overflow during absolute value calculation.
		long lDividend = Math.abs((long) dividend);
		long lDivisor = Math.abs((long) divisor);

		long result = 0;
		long temp = 0;

		// Iterate from the most significant bit (31st bit for a 32-bit integer) down to the least significant bit.

		// This approach performs division by repeatedly subtracting shifted versions of the divisor.
		for (int i = 31; i >= 0; i--) {
			// Check if subtracting (divisor left-shifted by i bits) from the current temporary value does not exceed the absolute value of the dividend.
			if ((temp + (lDivisor << i) <= lDividend)) {
				// If it doesn't exceed, it means the divisor (shifted by i bits) can fit into the remaining dividend.
				// Add the corresponding power of 2 (1 left-shifted by i bits) to the result.
				temp += lDivisor << i;
				result += ((long) 1 << i);
			}
		}

		// Apply the determined sign to the result
		if (sign < 0) {
			result = -result;
		}

		// Handle potential integer overflow by clamping the result to the Integer.MAX_VALUE or Integer.MIN_VALUE.
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return (int) result; // Cast the long result back to an int.
		}
	}
}
public class F6_Power {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10)); // 1024.0
        System.out.println(myPow(2.0, -2)); // 0.25
        System.out.println(myPow(5.0, 0)); // 1.0
    }

    public static double myPow(double x, int n) {
        // Base case: any number raised to the power of 0 is 1
        if (n == 0) {
            return 1;
        }

        // Recursive call: compute x^(n/2)
        double temp = myPow(x, n / 2);

        // If n is even, x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            // If n is odd and positive, x^n = x * (x^(n/2))^2
            if (n > 0) {
                return temp * temp * x;
            } else {
                // If n is odd and negative, x^n = (x^(n/2))^2 / x
                return temp * temp / x;
            }
        }
    }
}
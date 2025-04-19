public class F2_Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is: " + factorial(n));

        int n1 = 10;
        System.out.println("Factorial of " + n1 + " is: " + factorial(n1));
    }

    public static int factorial(int n) {
        // Base case:
        if (n == 1) {
            return 1;
        } else {
            // Recursive step:
            int temp = factorial(n - 1);
            return temp * n;
        }
    }
}
public class F3_Fibonacci {
    public static void main(String[] args) {
        int n = 2;
        System.out.println("Fibonacci of n = " + n + " is: " + fib(n));

        int n1 = 5;
        System.out.println("Fibonacci of n = " + n1 + " is: " + fib(n1));

        int n2 = 6;
        System.out.println("Fibonacci of n = " + n2 + " is: " + fib(n2));
    }

    public static int fib(int n) {
        // Base case: if n is 0 or 1, return n
        if (n == 0 || n == 1) {
            return n;
        }

        // Recursive case: call fib for (n-1) and (n-2), and return the sum
        int temp = fib(n - 1) + fib(n - 2);
        return temp;
    }
}
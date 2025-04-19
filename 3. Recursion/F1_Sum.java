public class F1_Sum {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Sum of first " + n + " natural numbers is: " + calculateSum(n));

        int n1 = 10;
        System.out.println("Sum of first " + n1 + " natural numbers is: " + calculateSum(n1));
    }

    public static int calculateSum(int n) {
        // Base case: sum of first 1 number is 1
        if (n == 1) {
            return 1;
        } else {
            // Recursive step: sum of first n numbers = n + sum of first (n - 1) numbers
            int temp = calculateSum(n - 1);
            return temp + n;
        }
    }
}
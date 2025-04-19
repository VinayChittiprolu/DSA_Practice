public class F5_Decreasing_Numbers {
    public static void main(String[] args) {
        int n = 4;
        printNumbers(n);
    }

    public static void printNumbers(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        printNumbers(n - 1);
    }
}
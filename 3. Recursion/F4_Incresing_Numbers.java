public class F4_Incresing_Numbers {
    public static void main(String[] args) {
        int n = 4;
        printNumbers(n);
    }

    public static void printNumbers(int n) {
        if (n == 0) {
            return;
        }

        printNumbers(n - 1);
        System.out.println(n);
    }
}
public class F4a_Square_Root {
    public static void main(String[] args) {
        System.out.println("The Integer Square root of 16 is: " + mySqrt(16));
        System.out.println("The Integer Square root of 82 is: " + mySqrt(82));
    }

    public static int mySqrt(int x) {
        int result = 0;

        while (result * result <= x) {
            result++;
        }
        return result - 1;
    }
}
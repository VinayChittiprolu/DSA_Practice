import java.util.Stack;

public class L12_Stock_Span_Array {
    public static void main(String[] args) {
        int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
        print(calculateSpan(arr));

        int[] arr1 = { 10, 4, 5, 90, 120, 80 };
        print(calculateSpan(arr1));
    }

    // Utility method to print Array
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] calculateSpan(int[] price) {
        int n = price.length;

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            // Pop indices from stack while current price is greater or equal
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // If stack is empty, span is i + 1 (everything before is smaller)
            result[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            stack.push(i); // Push this day's index to stack
        }
        return result;
    }
}
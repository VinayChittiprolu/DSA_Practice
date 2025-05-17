import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L12_Stock_Span_List {
    public static void main(String[] args) {
        int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
        System.out.println((calculateSpan(arr)));

        int[] arr1 = { 10, 4, 5, 90, 120, 80 };
        System.out.println((calculateSpan(arr1)));
    }

    public static List<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            // If stack is empty, span is i + 1 (everything before is smaller)
            result[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i); // Push this day's index to stack
        }

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            int index = result[i];
            output.add(index);
        }

        return output;
    }
}
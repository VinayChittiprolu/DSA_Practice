import java.util.ArrayList;
import java.util.Stack;

public class L12_Stock_Span_ArrayList {
    public static void main(String[] args) {
        int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
        print(calculateSpan(arr));

        int[] arr1 = { 10, 4, 5, 90, 120, 80 };
        print(calculateSpan(arr1));
    }

    // Utility method to print ArrayList<Integer>
    public static void print(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            // If stack is empty, span is i + 1 (everything before is smaller)
            if (stack.size() == 0) {
                result[i] = i + 1;
            } else {
                result[i] = i - stack.peek();
            }

            stack.push(i); // Push this day's index to stack
        }

        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            int ele = result[i];
            output.add(ele);
        }

        return output;
    }
}
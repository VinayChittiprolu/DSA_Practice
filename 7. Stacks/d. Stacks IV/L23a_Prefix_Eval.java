import java.util.Stack;

public class L23a_Prefix_Eval {
    public static void main(String[] args) {
        String[] arr = { "*", "+", "2", "1", "3" };
        System.out.println(evalPrefix(arr)); // Output: 9

        String[] arr1 = { "+", "4", "/", "13", "5" };
        System.out.println(evalPrefix(arr1)); // Output: 6

        String[] arr2 = { "+", "+", "*", "/", "*", "10", "6", "+", "9", "3", "-11", "17", "5" };
        System.out.println(evalPrefix(arr2)); // Output: 22
    }

    public static int evalPrefix(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            // Handling Operators
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = calc(a, b, token.charAt(0));
                stack.push(result);
            }
            // Handling Operands
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static int calc(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else if (operator == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }
}
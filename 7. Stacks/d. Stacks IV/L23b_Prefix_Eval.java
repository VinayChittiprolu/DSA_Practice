import java.util.Stack;

public class L23b_Prefix_Eval {
    public static void main(String[] args) {
        String[] arr = { "*", "+", "2", "1", "3" };
        System.out.println(evalPN(arr)); // Output: 9

        String[] arr1 = { "+", "4", "/", "13", "5" };
        System.out.println(evalPN(arr1)); // Output: 6

        String[] arr2 = { "+", "+", "*", "/", "*", "10", "6", "+", "9", "3", "-11", "17", "5" };
        System.out.println(evalPN(arr2)); // Output: 22
    }

    public static int evalPN(String[] tokens) {
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
                int num = 0;
                int sign = 1;
                int j = 0;

                if (token.charAt(0) == '-') {
                    sign = -1;
                    j = 1;
                }

                while (j < token.length()) {
                    char digit = token.charAt(j);
                    num = num * 10 + (digit - '0');
                    j++;
                }

                stack.push(sign * num);
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
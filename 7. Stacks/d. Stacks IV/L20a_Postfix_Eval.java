import java.util.Stack;

public class L20a_Postfix_Eval {
    public static void main(String[] args) {
        String[] arr = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(arr));

        String[] arr1 = { "4", "13", "5", "/", "+" };
        System.out.println(evalRPN(arr1));

        String[] arr2 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(evalRPN(arr2));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            // Handling Operators
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calc(a, b, token.charAt(0)));
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
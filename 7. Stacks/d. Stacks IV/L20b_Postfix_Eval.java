import java.util.Stack;

public class L20b_Postfix_Eval {
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
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calc(a, b, token.charAt(0)));
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
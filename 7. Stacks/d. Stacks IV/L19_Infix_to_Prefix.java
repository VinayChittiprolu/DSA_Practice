import java.util.Stack;

public class L19_Infix_to_Prefix {
    public static void main(String[] args) {
        System.out.println((infixToPrefix("A*B+C/D")));
        System.out.println((infixToPrefix("x+y*z/w+u")));
    }

    public static String infixToPrefix(String exp) {
        exp = reverseString(exp); // Reverse the input expression

        Stack<String> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        // Traverse from left to right since expression is reversed
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == ')') {
                operator.push(ch); // Push ')' as it will match with '(' in reversed expression

            } else if (ch == '(') {
                // Process until matching ')'
                while (operator.peek() != ')') {
                    processPrefix(operand, operator); // helper used here
                }
                operator.pop(); // Remove ')'

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                // Handle precedence
                while (!operator.isEmpty() && precedence(operator.peek()) > precedence(ch)) {
                    processPrefix(operand, operator); // helper used here
                }
                operator.push(ch);

            } else {
                // Operand (single letter or digit)
                operand.push(Character.toString(ch));
            }
        }

        // Process remaining operators
        while (!operator.isEmpty()) {
            processPrefix(operand, operator); // helper used here
        }

        return operand.pop(); // Final prefix expression
    }

    // Helper to apply operator in prefix order
    private static void processPrefix(Stack<String> operand, Stack<Character> operator) {
        char op = operator.pop();
        String a = operand.pop();
        String b = operand.pop();
        operand.push(op + a + b); // Operator comes before operands
    }

    public static int precedence(char operator) {
        if (operator == '^') {
            return 3;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 0; // For non-operator characters
        }
    }

    // Reverses the input string
    private static String reverseString(String str) {
        char[] arr = str.toCharArray();
        int start = 0, end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return new String(arr);
    }
}
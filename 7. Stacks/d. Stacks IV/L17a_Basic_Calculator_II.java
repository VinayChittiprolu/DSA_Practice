import java.util.Stack;

public class L17a_Basic_Calculator_II {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate("3/2"));
        System.out.println(calculate("3+5/2"));
    }

    public static int calculate(String s) {
        // Stack to store integer operands
        Stack<Integer> operands = new Stack<>();
        // Stack to store operators (+, -, *, /)
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is a digit, parse the full number
            if (ch >= '0' && ch <= '9') {
                int num = 0;
                // Build the number by processing consecutive digits
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                operands.push(num); // Push the parsed number to the operand stack
                i--; // Adjust index since the loop increments it after last digit
            }
            // If the character is an operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // Resolve previous operators with higher or equal precedence
                while (operators.size() > 0 && precedence(operators.peek()) >= precedence(ch)) {
                    char op = operators.pop();
                    int b = operands.pop();
                    int a = operands.pop();
                    int cal = calc(a, b, op);
                    operands.push(cal);
                }

                operators.push(ch); // Push current operators onto the stack
            }
        }

        // Process remaining operators in the stack
        while (operators.size() > 0) {
            char op = operators.pop();
            int b = operands.pop();
            int a = operands.pop();
            operands.push(calc(a, b, op));
        }

        return operands.pop(); // Final result is the only operand left
    }

    // Helper method to perform arithmetic operations
    public static int calc(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else if (operator == '*') {
            return a * b;
        } else {
            return a / b; // Assume b != 0 (no division by zero check here)
        }
    }

    // Helper method to define precedence of operators
    public static int precedence(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 0; // For unsupported characters
        }
    }
}
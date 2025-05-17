import java.util.Stack;

public class L18b_2_Infix_to_Postfix {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(infixToPostfix("A*(B+C)/D"));
        System.out.println(infixToPostfix("A*B+C/D"));
    }

    public static String infixToPostfix(String s) {
        Stack<String> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        // Traverse the input expression using a for loop
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                operator.push(ch); // Push opening bracket to operator stack

            } else if (ch == ')') {
                // Process until matching '(' is found
                while (operator.peek() != '(') {
                    process(operand, operator); // helper used here
                }
                operator.pop(); // remove '('

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                // Handle operator precedence
                while (!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)) {
                    process(operand, operator); // helper used here
                }
                operator.push(ch); // Push current operator

            } else {
                // operand.push(ch + "");
                operand.push(Character.toString(ch)); // Operand (assumes single-letter variables or digits)
            }
        }

        // Process any remaining operators
        while (!operator.isEmpty()) {
            process(operand, operator); // helper used here
        }

        return operand.pop(); // Final postfix expression
    }

    // Helper method to apply the operator to top two operands
    private static void process(Stack<String> operand, Stack<Character> operator) {
        char op = operator.pop();
        String b = operand.pop();
        String a = operand.pop();
        operand.push(a + b + op); // Convert to postfix
    }

    // Helper method to define operator precedence
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
}
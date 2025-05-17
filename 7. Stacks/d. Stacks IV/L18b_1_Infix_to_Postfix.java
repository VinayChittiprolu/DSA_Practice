import java.util.Stack;

public class L18b_1_Infix_to_Postfix {
    public static void main(String[] args) {
        System.out.println("Postfix: " + infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println("Postfix: " + infixToPostfix("A*(B+C)/D"));
        System.out.println("Postfix: " + infixToPostfix("A*B+C/D"));
    }

    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>(); // Stack to hold operators and parentheses
        StringBuilder result = new StringBuilder(); // To store the final postfix expression

        // Traverse each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is an operand (letter or digit), add it to the result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If the character is an opening parenthesis, push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is a closing parenthesis, pop and add to result until '(' is
            // found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove the '(' from the stack
            }
            // If the character is an operator
            else {
                // Pop operators from the stack with higher or equal precedence
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                // Push the current operator to the stack
                stack.push(ch);
            }
        }

        // Pop any remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // Return the final postfix expression
        return result.toString();
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
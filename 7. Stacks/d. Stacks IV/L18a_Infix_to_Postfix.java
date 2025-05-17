import java.util.Stack;

public class L18a_Infix_to_Postfix {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(infixToPostfix("A*(B+C)/D"));
        System.out.println(infixToPostfix("A*B+C/D"));
    }

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the scanned character is an operand, add it to output string.
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                result += ch;
            }
            // If the scanned character is an '(', push it to the stack.
            else if (ch == '(') {
                st.push('(');
            }
            // If the scanned character is an ')',pop and to output string from the stack
            // until an '(' is encountered.
            else if (ch == ')') {
                while (st.peek() != '(') {
                    result += st.peek();
                    st.pop();
                }
                st.pop();
            }
            // If an operator is scanned
            else {
                while (!st.empty() && precedence(s.charAt(i)) <= precedence(st.peek())) {
                    result += st.peek();
                    st.pop();
                }
                st.push(ch);
            }
        }

        while (!st.empty()) {
            result += st.peek();
            st.pop();
        }

        return result;
    }

    public static int precedence(char operator) {
        if (operator == '^')
            return 3;
        else if (operator == '*' || operator == '/')
            return 2;
        else if (operator == '+' || operator == '-')
            return 1;
        else
            return 0;
    }
}
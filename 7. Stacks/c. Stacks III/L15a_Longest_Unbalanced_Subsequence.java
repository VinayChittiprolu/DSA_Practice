import java.util.Stack;

public class L15a_Longest_Unbalanced_Subsequence {
    public static void main(String[] args) {
        String string = ")))))))))))))))))))))))((";
        find(string);

        String string2 = "()[]{}";
        find(string2);

        String string3 = "(())()";
        find(string3);

        String string4 = "([)]";
        find(string4);

        String string5 = "(((";
        find(string5);
    }

    // Method to check the result and print string length logic
    public static void find(String string) {
        if (isValid(string)) {
            System.out.print("length of longest balanced subsequence is: ");
            System.out.println(string.length());
        } else {
            System.out.print("length of longest unbalanced subsequence is: ");
            System.out.println(string.length());
        }
    }

    public static boolean isValid(String s) {
        // Stack to keep track of opening brackets
        Stack<Character> st = new Stack<>();
        int i = 0;

        // Loop through each character in the string
        while (i < s.length()) {
            char ch = s.charAt(i);

            // If it's an opening bracket, push it onto the stack
            if (st.size() == 0
                    || ch == '('
                    || ch == '['
                    || ch == '{') {
                st.push(ch);
            } else {
                // If it's a closing bracket, check if it matches the top of the stack
                if (ch == ')' && st.peek() == '('
                        || (ch == ']' && st.peek() == '[')
                        || (ch == '}' && st.peek() == '{')) {
                    // If it matches, pop the opening bracket from the stack
                    st.pop();
                } else {
                    return false; // If it doesn't match, the string is invalid
                }
            }
            i++; // Move to the next character
        }
        // If the stack is empty, all brackets were matched correctly
        return st.empty();
    }
}
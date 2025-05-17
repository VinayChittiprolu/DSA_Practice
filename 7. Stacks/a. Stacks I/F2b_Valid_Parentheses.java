import java.util.Stack;

public class F2b_Valid_Parentheses {
    public static void main(String[] args) {
        String string = "(}[]{)";
        System.out.println(isValid(string));

        String string1 = "({[]})";
        System.out.println(isValid(string1));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (st.isEmpty() || ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.peek() == '(' && ch == ')' || st.peek() == '[' && ch == ']'
                        || st.peek() == '{' && ch == '}') {
                    st.pop();
                } else {
                    return false;
                }
            }
            i++;
        }

        // if the stack is empty then the parenthesis are balanced.
        if (st.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
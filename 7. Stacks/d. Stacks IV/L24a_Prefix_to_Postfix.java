import java.util.Stack;

public class L24a_Prefix_to_Postfix {
    public static void main(String[] args) {
        String st = "*-A/BC-/AKL";
        System.out.println(preToPost(st)); // ABC/-AK/L-*

        // System.out.println(preToPost("ab+"));
    }

    static String preToPost(String exp) {
        Stack<String> stack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String a = stack.pop();
                String b = stack.pop();

                stack.push(a + b + ch);
            } else {
                stack.push(ch + "");
            }
        }

        return stack.pop();
    }
}
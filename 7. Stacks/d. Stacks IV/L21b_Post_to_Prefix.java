import java.util.Stack;

public class L21b_Post_to_Prefix {
    public static void main(String[] args) {
        String st = "ABC/-AK/L-*";
        System.out.println(postToPre(st)); // *-A/BC-/AKL

        System.out.println(postToPre("ab+"));
    }

    public static String postToPre(String exp) {
        Stack<StringBuilder> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                StringBuilder b = stack.pop();
                StringBuilder a = stack.pop();

                StringBuilder sb = new StringBuilder();
                sb.append(ch).append(a).append(b);
                stack.push(sb);
            } else {
                stack.push(new StringBuilder().append(ch));
            }
        }

        return stack.pop().toString();
    }
}
import java.util.Stack;

public class L22b_Postfix_to_Infix {
    public static void main(String[] args) {
        String st = "abc++";
        System.out.println(postToInfix(st)); // (a+(b+c))

        String str = "ab*c+";
        System.out.println(postToInfix(str)); // ((a*b)+c)
    }

    static String postToInfix(String exp) {
        Stack<StringBuilder> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                StringBuilder b = stack.pop();
                StringBuilder a = stack.pop();

                StringBuilder sb = new StringBuilder();
                sb.append('(').append(a).append(ch).append(b).append(')');
                stack.push(sb);
            } else {
                stack.push(new StringBuilder().append(ch));
            }
        }
        return stack.pop().toString();
    }
}
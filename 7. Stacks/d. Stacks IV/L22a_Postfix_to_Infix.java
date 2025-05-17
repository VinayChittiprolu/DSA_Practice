import java.util.Stack;

public class L22a_Postfix_to_Infix {
    public static void main(String[] args) {
        String st = "abc++";
        System.out.println(postToInfix(st)); // (a+(b+c))

        String str = "ab*c+";
        System.out.println(postToInfix(str)); // ((a*b)+c)
    }

    static String postToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String b = stack.pop();
                String a = stack.pop();
                stack.push('(' + a + ch + b + ')');
            } else {
                stack.push(ch + "");
            }
        }
        return stack.pop();
    }
}
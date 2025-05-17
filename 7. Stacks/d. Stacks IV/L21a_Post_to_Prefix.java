import java.util.Stack;

public class L21a_Post_to_Prefix {
    public static void main(String[] args) {
        String st = "ABC/-AK/L-*";
        System.out.println(postToPre(st)); // *-A/BC-/AKL

        System.out.println(postToPre("ab+"));
    }

    public static String postToPre(String exp) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String b = stack.pop();
                String a = stack.pop();
                
                stack.push(ch + a + b);
            } else {
                stack.push(ch + "");
            }
        }
        return stack.pop();
    }
}
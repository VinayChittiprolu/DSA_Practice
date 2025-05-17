import java.util.Stack;

public class L15c {
    public static void main(String[] args) {
        String input1 = "(()))(";
        System.out.println("Input: " + input1 + " -> Unbalanced sequence length: " + lengthOfSequence(input1));
        
        String input2 = "()()";
        System.out.println("Input: " + input2 + " -> Unbalanced sequence length: " + lengthOfSequence(input2));
        
        String input3 = "((())";
        System.out.println("Input: " + input3 + " -> Unbalanced sequence length: " + lengthOfSequence(input3));
    }

    public static int lengthOfSequence(String string) {
        Stack<Character> stack = new Stack<>();

        // Iterate through the string to process parentheses
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        // If stack is not empty, the string is unbalanced
        return stack.isEmpty() ? 0 : string.length();
    }
}
import java.util.Stack;

public class L15b {
    public static void main(String[] args) {
        String input1 = ")))))))))))))))))))))))((";
        System.out.println("Input: " + input1 + " -> Unbalanced sequence length: " + lengthOfSequence(input1));

        String input2 = "()()";
        System.out.println("Input: " + input2 + " -> Unbalanced sequence length: " + lengthOfSequence(input2));

        String input3 = "(()())";
        System.out.println("Input: " + input3 + " -> Unbalanced sequence length: " + lengthOfSequence(input3));

        String input4 = "(()))(";
        System.out.println("Input: " + input4 + " -> Unbalanced sequence length: " + lengthOfSequence(input4));

        // String input5 = ")()())";
        System.out.println("Input: " + ")()())" + " -> Unbalanced sequence length: " + lengthOfSequence(")()())"));
    }

    public static int lengthOfSequence(String string) {
        Stack<Character> stack = new Stack<>();

        // Iterate through the string to process parentheses
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == '(') {
                // If '(' is encountered, push it onto the stack
                stack.push(ch);
            } else if (ch == ')') {
                // If ')' is encountered, check if there's a matching '(' on the stack
                if (!stack.isEmpty() && stack.peek() == '(') {
                    // If there is a match, pop the '('
                    stack.pop();
                } else {
                    // If no match, push the ')' onto the stack
                    stack.push(ch);
                }
            }
        }

        // The stack now contains the unmatched parentheses, which form the unbalanced
        // subsequence
        return stack.size();
    }
}
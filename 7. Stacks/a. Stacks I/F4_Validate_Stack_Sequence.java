import java.util.Stack;

public class F4_Validate_Stack_Sequence {
    public static void main(String args[]) {
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 4, 5, 3, 2, 1 };
        System.out.println("Is sequence valid?: " + validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0; // Tracks index for 'pushed' array
        int j = 0; // Tracks index for 'popped' array

        // Process all elements from the 'pushed' array
        for (i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]); // Push current element onto the stack

            // Keep popping from the stack as long as the top matches the current element in
            // 'popped'
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty(); // If all elements were popped in the correct order, the stack should be empty
    }
}
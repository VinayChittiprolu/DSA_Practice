import java.util.Stack;

class F1b_Remove_Adjecent_Duplicates {
    public static void main(String[] args) {
        String str = "abbbbd";
        System.out.println("Output: " + removeAdjacentDuplicates(str));
        System.out.println("Output: " + removeAdjacentDuplicates("abbaca"));
        System.out.println("Output: " + removeAdjacentDuplicates("9966150499"));
    }

    public static String removeAdjacentDuplicates(String str) {
        Stack<Character> st = new Stack<>();

        // Traverse each character in the input string
        for (int i = 0; i < str.length(); i++) {

            // If stack is not empty and top of stack equals current character
            if (!st.isEmpty() && st.peek() == str.charAt(i)) {
                st.pop(); // Remove duplicate
            } else {
                st.push(str.charAt(i)); // Add current character to stack
            }
        }

        // Now stack contains result in reverse order
        char[] result = new char[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop(); // Pop characters in reverse to correct order
        }
        return String.valueOf(result); // Convert char array to string and return
    }
}
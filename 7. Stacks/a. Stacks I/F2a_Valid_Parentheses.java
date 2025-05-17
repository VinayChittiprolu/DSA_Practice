public class F2a_Valid_Parentheses {
    public static void main(String[] args) {
        String string = "(}[]{)";
        System.out.println(isValid(string));

        String string1 = "({[]})";
        System.out.println(isValid(string1));
    }

    public static boolean isValid(String s) {
        boolean changed = true;
    
        while (changed) {
            changed = false;
            for (int i = 0; i < s.length() - 1; i++) {
                char a = s.charAt(i);
                char b = s.charAt(i + 1);
    
                if ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']')) {
                    // Remove matched pair
                    s = s.substring(0, i) + s.substring(i + 2);
                    changed = true;
                    break; // Start over after any deletion
                }
            }
        }
        return s.isEmpty();
    }
}
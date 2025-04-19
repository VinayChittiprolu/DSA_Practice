public class F7_Palindrome {
    public static void main(String[] args) {
        String str = "aBcba";
        System.out.println(isPalindrome(str, 0, str.length() - 1));
    }

    public static boolean isPalindrome(String str, int s, int e) {
        // Convert the string to lowercase to make the check case-insensitive
        str = str.toLowerCase();

        // Base case: if the starting index is greater than or equal to the ending index,
        // we have checked all characters, so it's a palindrome
        if (s >= e) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        // Recursively check the next pair of characters inward
        return isPalindrome(str, s + 1, e - 1);
    }
}
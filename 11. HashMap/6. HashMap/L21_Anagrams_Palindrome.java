import java.util.HashMap;

public class L21_Anagrams_Palindrome {
    public static void main(String[] args) {
        String s1 = "carrace";
        String s2 = "hello";
        System.out.println("Is Anagram Palindrome: " + isAnagramPalindrome(s1)); // true
        System.out.println("Is Anagram Palindrome: " + isAnagramPalindrome(s2)); // false
    }

    public static int isAnagramPalindrome(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>(); // Frequency map to count character occurrences

        // Count character frequencies
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int oddCount = 0; // Count of characters with odd frequency

        // Check the frequency of characters
        for (int count : freqMap.values()) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        // For a string to be an anagram of a palindrome, it can have at most one
        // character with an odd frequency
        if (oddCount > 1) {
            return 0;
        }

        return 1;
    }
}
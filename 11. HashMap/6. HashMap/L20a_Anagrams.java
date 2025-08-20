import java.util.*;

public class L20a_Anagrams {
    public static void main(String[] args) {
        // String s = "cbaebabacd";
        // String p = "abc";

        String s = "abab";
        String p = "ab";

        List<Integer> result = findAnagrams(s, p);
        System.out.println("Anagram indices: " + result);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // frequency count for the string p
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        // Sliding window to count frequency of characters in s
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            // Remove the character that is out of the window
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare counts
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
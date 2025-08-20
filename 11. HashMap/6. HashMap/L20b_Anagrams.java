import java.util.*;

public class L20b_Anagrams {
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
        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Build frequency map for string p
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i); // Add current character to pMap
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        int windowSize = p.length();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // Add current character to windowMap
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            // Remove character left out of the window
            if (i >= windowSize) {
                char leftChar = s.charAt(i - windowSize);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }
            }

            // Compare window map and pattern map
            if (windowMap.equals(pMap)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}
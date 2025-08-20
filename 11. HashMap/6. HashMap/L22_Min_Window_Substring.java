import java.util.*;

public class L22_Min_Window_Substring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println("Minimum window substring: " + result);
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        int sp = 0, ep = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int matched = 0; // Count of characters matched in the current window

        while (ep < s.length()) {
            char ch2 = s.charAt(ep);
            window.put(ch2, window.getOrDefault(ch2, 0) + 1);

            if (target.containsKey(ch2) && window.get(ch2) <= target.getOrDefault(ch2, 0)) {
                matched++;
            }
            ep++;

            while (matched == t.length()) {
                if (ep - sp < minLen) {
                    minLen = ep - sp;
                    start = sp;
                }
                char ch1 = s.charAt(sp);
                window.put(ch1, window.get(ch1) - 1);
                if (target.containsKey(ch1) && window.get(ch1) < target.get(ch1)) {
                    matched--;
                }
                sp++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class L6_First_Non_Repeating_Char {
    public static void main(String[] args) {
        System.out.println(FirstNonRepeating("aabc"));
        System.out.println(FirstNonRepeating("abcabc"));
    }

    public static String FirstNonRepeating(String str) {
        // To maintain the order of characters as they appear (FIFO).
        Queue<Character> q = new LinkedList<>();

        // To store the frequency count of each character.
        HashMap<Character, Integer> hm = new HashMap<>();

        // To store the resulting characters step by step.
        char[] ans = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch); // Add the current character to the queue.

            // Update frequency in hashmap
            if (hm.containsKey(ch)) {
                int temp = hm.get(ch);
                hm.put(ch, temp + 1);
            } else {
                hm.put(ch, 1);
            }

            // Remove repeating characters from front of queue
            while (q.size() > 0 && hm.get(q.peek()) > 1) {
                q.remove();
            }

            // Build output string
            if (q.size() > 0) {
                // If the queue is not empty, the front character is the first non-repeating
                // character so far.
                ans[i] = q.peek();
            } else {
                // If the queue is empty, there are no non-repeating characters so add '#'
                ans[i] = '#';
            }
        }
        // Convert the array of characters to a string and return it
        return String.valueOf(ans);
    }
}
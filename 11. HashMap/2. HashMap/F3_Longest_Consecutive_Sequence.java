import java.util.HashMap;

public class F3_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2 }; 
        System.out.println(longConSeq(arr)); 

        int[] arr1 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }; 
        System.out.println(longConSeq(arr1)); 
    }

    public static int longConSeq(int[] num) {
        // HashMap to store the length of sequences at their start and end points
        HashMap<Integer, Integer> hm = new HashMap<>();
        // Variable to keep track of the maximum length of consecutive sequences
        int maxLen = 0;

        // Iterate through each number in the input array
        for (int i = 0; i < num.length; i++) {
            // If the current number is not already in the HashMap
            if (!hm.containsKey(num[i])) {
                // Initialize start point (sp) and end point (ep) to the current number
                int sp = num[i];
                int ep = num[i];

                // Check if there is a sequence ending just before the current number
                if (hm.containsKey(num[i] - 1)) {
                    // Update the start point to extend the sequence backwards
                    sp = sp - hm.get(num[i] - 1);
                }

                // Check if there is a sequence starting just after the current number
                if (hm.containsKey(num[i] + 1)) {
                    // Update the end point to extend the sequence forwards
                    ep = ep + hm.get(num[i] + 1);
                }

                // Calculate the current sequence length
                int cur_len = ep - sp + 1;

                // Update the HashMap with the start and end points of the current sequence
                hm.put(sp, cur_len);
                hm.put(ep, cur_len);

                // If the current number is not the start or end point, store it with length 1
                if (sp != num[i] && ep != num[i]) {
                    hm.put(num[i], 1);
                }

                // Update the maximum length found so far
                maxLen = Math.max(maxLen, cur_len);
            }
        }

        // Return the length of the longest consecutive sequence found
        return maxLen;
    }
}
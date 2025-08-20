import java.util.HashMap;

public class L4b {
    public static void main(String[] args) {
        String str = "11100022";
        System.out.println("Substrings with equal numbers of 0s, 1s, and 2s: " + countEquals(str));

        String str1 = "0102010";
        System.out.println("Substrings with equal numbers of 0s, 1s, and 2s: " + countEquals(str1));
    }

    public static int countEquals(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", 1); // Initial diff pair

        int count = 0;
        int count0 = 0, count1 = 0, count2 = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '0') {
                count0++;
            } else if (ch == '1') {
                count1++;
            } else if (ch == '2') {
                count2++;
            }

            int diff10 = count1 - count0;
            int diff21 = count2 - count1;

            String key = diff10 + "#" + diff21;

            count += map.getOrDefault(key, 0); // Add frequency of same diff pair
            map.put(key, map.getOrDefault(key, 0) + 1); // Update the frequency
        }

        return count;
    }
}
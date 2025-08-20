import java.util.*;

public class Random_Pick {
    HashMap<Integer, Integer> map;
    Random random;
    int valid;

    public Random_Pick(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();

        // Initialize the map with blacklisted numbers
        for (int i = 0; i < blacklist.length; i++) {
            map.put(blacklist[i], -1); // Mark blacklisted numbers
        }

        valid = n - blacklist.length;
        int last = n - 1;

        // Fill the map with valid numbers
        for (int i = 0; i < blacklist.length; i++) {
            int b = blacklist[i];
            if (b < valid) {
                while (map.containsKey(last)) {
                    last--;
                }
                map.put(b, last);
                last--;
            }
        }
    }

    public int pick() {
        int index = random.nextInt(valid);
        if (map.containsKey(index)) {
            return map.get(index);
        }
        return index; // Return the index if it's not blacklisted
    }
}
import java.util.LinkedHashMap;

public class L19a_LRU_Cache {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);

        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // returns 1

        lru.put(3, 3); // evicts key 2
        System.out.println(lru.get(2)); // returns -1 (not found)

        lru.put(4, 4); // evicts key 1
        System.out.println(lru.get(1)); // returns -1 (not found)
        System.out.println(lru.get(3)); // returns 3
        System.out.println(lru.get(4)); // returns 4
    }

    public static class LRUCache {
        private int capacity;
        private LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            // true for access-order (LRU), false for insertion-order
            map = new LinkedHashMap<>(capacity, 0.75f, true);
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
            if (map.size() > capacity) {
                // Remove the eldest entry
                map.remove(map.entrySet().iterator().next().getKey());
            }
        }
    }
}
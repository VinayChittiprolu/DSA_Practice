// import java.util.HashMap;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Set;
// import java.util.Random;

import java.util.*;

public class RandomizedSet_II {
    HashMap<Integer, Set<Integer>> map;
    List<Integer> list;
    Random random;

    public RandomizedSet_II() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val) || map.get(val).isEmpty();

        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }

        map.get(val).add(list.size());
        list.add(val);

        return notPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        Set<Integer> indices = map.get(val);
        int indexToRemove = indices.iterator().next();
        indices.remove(indexToRemove);

        if (indices.isEmpty()) {
            map.remove(val);
        }

        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        // Swap the element to be removed with the last one
        list.set(indexToRemove, lastVal);
        if (map.containsKey(lastVal)) {
            map.get(lastVal).remove(lastIndex);
            map.get(lastVal).add(indexToRemove);
        }

        // Remove the last element
        list.remove(lastIndex);

        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

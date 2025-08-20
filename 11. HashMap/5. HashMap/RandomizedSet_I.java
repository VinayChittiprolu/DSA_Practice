import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet_I {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet_I() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val) == false) {
            return false;
        }

        int index = map.get(val);
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        // Swap the element to be removed with the last one
        list.set(index, lastVal);
        map.put(lastVal, index);

        // Remove the last element
        list.remove(lastIndex);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
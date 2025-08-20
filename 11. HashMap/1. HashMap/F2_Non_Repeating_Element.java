import java.util.HashMap;

public class F2_Non_Repeating_Element {
    public static void main(String[] args) {
        int[] arr = { -1, 2, -1, 3, 2 };
        System.out.println(firstNonRep(arr) + " is the first non-repeating element");

        int[] arr1 = { 1, 1, 1 };
        if (firstNonRep(arr1) < 0) {
            System.out.println("Array is empty");
        } else {
            System.out.println(firstNonRep(arr1) + " is the first non-repeating element");
        }

        String[] arr2 = { "apple", "banana", "apple", "orange", "banana" };
        System.out.println(firstNonRepString(arr2) + " is the first non-repeating string");
    }

    public static int firstNonRep(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int temp = map.get(arr[i]);
                map.put(arr[i], temp + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return -1;
    }

    public static String firstNonRepString(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Step 2: Return first string with frequency 1
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return arr[i];
            }
        }

        return "No Unique String"; // Or return null, or any suitable default
    }
}
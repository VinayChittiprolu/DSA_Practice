import java.util.HashSet;

public class L5a_Find_Pair {
    public static void main(String[] args) {
        int arr[] = { 5, 20, 3, 2, 5, 80 };
        int x = 78;
        if (findPair(arr, x)) {
            System.out.println("Pair with given difference found");
        } else {
            System.out.println("No pair with given difference found");
        }

        int arr1[] = { 90, 70, 20, 80, 50 };
        int x1 = 45;
        if (findPair(arr1, x1)) {
            System.out.println("Pair with given difference found");
        } else {
            System.out.println("No pair with given difference found");
        }
    }

    public static boolean findPair(int arr[], int x) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            // Check if (num + x) or (num - x) already exists in the set
            if (set.contains(num + x) || set.contains(num - x)) {
                return true;
            }
            // Add the current number to the set
            set.add(num);
        }

        // No pair found
        return false;
    }
}
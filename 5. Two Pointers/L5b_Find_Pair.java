import java.util.Arrays;

public class L5b_Find_Pair {
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
        int n = arr.length;

        // Sort the array to make two-pointer approach feasible
        Arrays.sort(arr);

        int i = 0; // Pointer to the first element
        int j = 1; // Pointer to the second element

        // Traverse the array with two pointers
        while (i < n && j < n) {
            // Ensure we don't compare the same element with itself
            if (i != j && arr[j] - arr[i] == x) {
                // If the difference is exactly x, pair is found
                return true;
            } else if (arr[j] - arr[i] > x) {
                // If the difference is greater than x, move the first pointer to reduce the
                // difference
                i++;
            } else {
                // If the difference is less than x, move the second pointer to increase the
                // difference
                j++;
            }
        }

        return false;
    }
}
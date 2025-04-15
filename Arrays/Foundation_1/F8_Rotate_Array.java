import java.util.Arrays;

public class F8_Rotate_Array {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 4;

        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;

        // Ensure k does not exceed the length of the array
        k = k % n; // If k > n, rotating by k is the same as k % n

        reverse(arr, 0, n - 1); // Reverse the entire array
        reverse(arr, 0, k - 1); // Reverse the first k elements
        reverse(arr, k, n - 1); // Reverse the remaining n-k elements
    }

    public static void reverse(int arr[], int sp, int ep) {
        // Swap elements at start and end indices
        while (sp < ep) {
            int temp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = temp;

            // Move pointers towards each other
            sp++;
            ep--;
        }
    }
}
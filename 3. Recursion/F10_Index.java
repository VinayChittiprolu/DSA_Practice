public class F10_Index {
    public static void main(String[] args) {
        int[] arr = { 2, 8, 6, 4 };
        int k = 5;
        System.out.println(findIndex(arr, k, 0));

        int[] arr1 = { 10, 20, 30, 40, 50 };
        int k1 = 40;
        System.out.println(findIndex(arr1, k1, 0));
    }

    public static int findIndex(int arr[], int k, int i) {
        // Base case: if 'i' reaches the length of the array, the element was not found
        if (i == arr.length) {
            return -1; // Return -1 to indicate 'k' is not in the array
        }

        // Check if the current element at index 'i' matches 'k'
        if (arr[i] == k) {
            return i; // Return the index where the element is found
        }

        // Recursive call: check the next element by increasing index 'i'
        return findIndex(arr, k, i + 1);
    }
}
public class F9_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 4, 5 };
        System.out.println(isSorted(arr, 0));

        int[] arr1 = { 10, 25, 30, 45, 50 };
        System.out.println(isSorted(arr1, 0));

    }

    public static boolean isSorted(int arr[], int i) {
        // Base case: if we are at the last element, return true (nothing to compare)
        if (i == arr.length - 1) {
            return true;
        }

        // Check if the current element is greater than the next element
        if (arr[i] > arr[i + 1]) {
            // If current element is greater, array is not sorted
            return false;
        }

        // Recursively check the rest of the array
        return isSorted(arr, i + 1);
    }
}
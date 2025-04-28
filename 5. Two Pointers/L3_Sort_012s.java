public class L3_Sort_012s {
    public static void main(String[] args) {
        int arr[] = { 0, 2, 1, 2, 0 };

        sort012(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort012(int arr[]) {
        int low = 0; // Pointer for next position of 0
        int mid = 0; // Current element pointer
        int high = arr.length - 1; // Pointer for next position of 2

        // Process elements until mid exceeds high
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap current element with element at low
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // If the element is 1, just move mid forward
                mid++;
            } else {
                // If the element is 2, swap it with element at high
                swap(arr, mid, high);
                high--;
                // Do not move mid forward, because swapped element might be 0, 1, or 2
            }
        }
    }

    // Helper function to swap two elements in the array
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
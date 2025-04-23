public class L13_Rearrange_Array {
    public static void main(String[] args) {
        // int[] arr = { 10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14 };
        int[] arr = { 50, 20, 60, 10, 40, 70, 30 };
        partition(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void partition(int arr[]) {
        int i = 1; // Start scanning from the element next to pivot
        int j = arr.length - 1; // Start scanning from the end

        while (i <= j) {
            // Move left pointer forward if current element is less than or equal to pivot
            if (arr[i] <= arr[0]) {
                i++;
            }
            // Move right pointer backward if current element is greater than pivot
            else if (arr[j] > arr[0]) {
                j--;
            }
            // If left is greater than pivot and right is less than or equal to pivot, swap
            // them
            else {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        swap(arr, 0, j); // Place the pivot in its correct position
    }

    // Helper method to swap two elements in the array
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
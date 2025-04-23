public class L8_Merge_Sort {
    public static void main(String[] args) {
        int arr[] = { 8, 3, 1, 6, 4, 7, 2, 5 };

        // Sort the array using mergeSort function
        mergeSort(arr, 0, arr.length - 1);

        System.out.print("Sorted array: ");
        printArray(arr);
    }

    // Recursive merge sort function that returns mergeSort
    public static void mergeSort(int[] arr, int s, int e) {
        // Base case: 0 or 1 element → no inversions
        if (s >= e) {
            return;
        }

        int m = s + (e - s) / 2; // Avoid overflow for large s and e

        mergeSort(arr, s, m); // Sort the first half of the array
        mergeSort(arr, m + 1, e); // Sort the second half of the array
        mergeSubarray(arr, s, m, e); // Merge the sorted halves
    }

    // Method to Merge two sorted subarrays
    public static int[] mergeSubarray(int arr[], int s, int m, int e) {
        int mergedArray[] = new int[e - s + 1];

        int i = s; // Pointer for the first subarray
        int j = m + 1; // Pointer for the second subarray
        int k = 0; // Pointer for the mergedArray

        // Merge elements from both subarrays in sorted order
        while (i <= m && j <= e) {
            if (arr[i] < arr[j]) {
                mergedArray[k] = arr[i];
                k++;
                i++;
            } else {
                mergedArray[k] = arr[j];
                k++;
                j++;
            }
        }

        // Copy any remaining elements from the first subarray
        while (i <= m) {
            mergedArray[k] = arr[i];
            k++;
            i++;
        }

        // Copy any remaining elements from the second subarray
        while (j <= e) {
            mergedArray[k] = arr[j];
            k++;
            j++;
        }

        // Copy mergedArray back into the original array
        for (int p = 0; p < mergedArray.length; p++) {
            arr[s + p] = mergedArray[p];
        }

        return arr;
    }

    // Utility method to print an array
    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
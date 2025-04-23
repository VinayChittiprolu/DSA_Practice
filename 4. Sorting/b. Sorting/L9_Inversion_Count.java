public class L9_Inversion_Count {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 5 };

        System.out.println("Inversion Count: " + countInversions(arr));
    }

    // method to start inversion count
    public static int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Recursive merge sort function that returns inversion count
    public static int mergeSortAndCount(int arr[], int s, int e) {
        // Base case: 0 or 1 element → no inversions
        if (s >= e) {
            return 0;
        }

        int Count = 0;
        int m = s + (e - s) / 2; // Avoid overflow for large s and e

        Count += mergeSortAndCount(arr, s, m); // Count inversions in left half
        Count += mergeSortAndCount(arr, m + 1, e); // Count inversions in right half
        Count += mergeAndCount(arr, s, m, e); // Count split inversions during merge step

        return Count;
    }

    // Merge two sorted subarrays and count cross-inversions
    public static int mergeAndCount(int arr[], int s, int m, int e) {
        int mergedArray[] = new int[e - s + 1];

        int i = s; // Pointer for the first subarray
        int j = m + 1; // Pointer for the second subarray
        int k = 0; // Pointer for the mergedArray
        int Count = 0; // To store inversion count

        // Merge elements from both subarrays and count inversions
        while (i <= m && j <= e) {
            if (arr[i] <= arr[j]) {
                mergedArray[k] = arr[i];
                k++;
                i++;
            } else {
                mergedArray[k] = arr[j];
                k++;
                j++;
                // All remaining elements in left subarray are greater than arr[j]
                Count += (m - i + 1);
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

        return Count;
    }
}
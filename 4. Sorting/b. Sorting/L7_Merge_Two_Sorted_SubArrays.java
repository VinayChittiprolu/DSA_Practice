public class L7_Merge_Two_Sorted_SubArrays {
    public static void main(String[] args) {
        int[] arr = { 4, 8, -1, 2, 6, 9, 11, 3, 4, 7, 13, 0 };

        int s = 2;
        int m = 6;
        int e = 9;

        int[] final_arr = mergeSubarray(arr, s, m, e);

        for (int i = 0; i < final_arr.length; i++) {
            System.out.print(final_arr[i] + " ");
        }
    }

    public static int[] mergeSubarray(int arr[], int s, int m, int e) {
        // Create a temporary array to hold the merged result
        int mergedArray[] = new int[e - s + 1];

        int i = s; // i -> pointer for the first subarray (from s to m)
        int j = m + 1; // j -> pointer for the second subarray (from m+1 to e)
        int k = 0; // k -> pointer for the mergedArray

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

        // Copy any remaining elements from the first subarray (if any)
        while (i <= m) {
            mergedArray[k] = arr[i];
            k++;
            i++;
        }

        // Copy any remaining elements from the second subarray (if any)
        while (j <= e) {
            mergedArray[k] = arr[j];
            k++;
            j++;
        }

        // Copy the merged elements back to the original array
        for (int p = 0; p < mergedArray.length; p++) {
            arr[s + p] = mergedArray[p];
        }

        return arr;
    }
}
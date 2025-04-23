public class L6_Mege_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7, 9 };
        int[] arr2 = { 2, 4, 6, 8, 10 };

        int[] final_arr = MergeSortedArrays(arr1, arr2);

        for (int i = 0; i < final_arr.length; i++) {
            System.out.print(final_arr[i] + " ");
        }
    }


    public static int[] MergeSortedArrays(int arr1[], int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int mergedArray[] = new int[n + m];
        int i = 0, j = 0, k = 0;

        // Merge elements from both arrays in sorted order
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k] = arr1[i];
                k++;
                i++;
            } else {
                mergedArray[k] = arr2[j];
                k++;
                j++;
            }
        }

        // Copy remaining elements from firstArray, if any
        while (i < n) {
            mergedArray[k] = arr1[i];
            k++;
            i++;
        }

        // Copy remaining elements from secondArray, if any
        while (j < m) {
            mergedArray[k] = arr2[j];
            k++;
            j++;
        }

        return mergedArray;
    }
}
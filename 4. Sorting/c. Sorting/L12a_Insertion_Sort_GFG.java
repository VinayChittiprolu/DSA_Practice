public class L12a_Insertion_Sort_GFG {
    public static void main(String[] args) {
        int arr[] = { 4, 1, 9 };
        // int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            insertBySwapping(arr, i);
        }
    }

    public static void insertBySwapping(int[] arr, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j + 1] < arr[j]) {
                // Swap if the element on the left is greater
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            } else {
                break; // Stop if the order is correct
            }
        }
    }
}
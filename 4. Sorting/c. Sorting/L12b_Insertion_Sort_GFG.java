public class L12b_Insertion_Sort_GFG {
    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        // int arr[] = { 4, 1, 9 };

        insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[i] < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = arr[i];
        }
    }
}
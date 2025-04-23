public class L4_Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = { 7, 9, 3, 10, 4 };
        bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;

        // Outer loop: controls the number of passes through the array
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: compares adjacent elements and swaps them if needed
            for (int j = 0; j < n - 1 - i; j++) {
                // If the current element is greater than the next element, swap them
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // After each pass, the largest unsorted element is placed at the end
        }
    }
}
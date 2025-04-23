public class L11_Sort_Partially_Sorted_array {
    public static void main(String[] args) {
        // int arr[] = { 2, 6, 10, 14, 20, 4 };
        int arr[] = { 1, 3, 5, 7, 4 };

        insertLastElement(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertLastElement(int arr[]) {
        int n = arr.length;

        // Start from the second last element and move backwards
        for (int i = n - 2; i >= 0; i--) {
            // If the current element is greater than the one after it, swap them
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            } else {
                break; // If the current element is already smaller or equal, no more swaps are needed
            }
        }
    }
}
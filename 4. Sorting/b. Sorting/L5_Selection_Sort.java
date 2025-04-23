public class L5_Selection_Sort {
    public static void main(String[] args) {
        int[] arr = { 7, 9, 3, 10, 4 };
        selectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse through all elements in the array
        for (int i = 0; i < n; i++) {
            int smallestValue = arr[i]; // Assume the current index has the smallest value
            int smallestIndex = i;

            // Find the smallest element in the remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < smallestValue) {
                    smallestValue = arr[j];
                    smallestIndex = j;
                }
            }

            // Swap the found smallest element with the current element
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
}
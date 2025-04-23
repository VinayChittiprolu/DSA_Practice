public class L15_Quick_Sort {
    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 9, 7 };
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Function to sort an array using quick sort algorithm.
    public static void quickSort(int arr[], int s, int e) {
        if (s >= e) {
            return;
        }
        int p = partition(arr, s, e);

        quickSort(arr, s, p - 1);
        quickSort(arr, p + 1, e);
    }

    public static int partition(int arr[], int s, int e) {
        int i = s + 1;
        int j = e;

        while (i <= j) {
            if (arr[i] <= arr[s]) {
                i++;
            } else if (arr[j] > arr[s]) {
                j--;
            } else {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        swap(arr, s, j);
        return j;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
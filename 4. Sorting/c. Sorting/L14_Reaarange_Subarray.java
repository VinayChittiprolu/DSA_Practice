public class L14_Reaarange_Subarray {
    public static void main(String[] args) {
        int[] arr = { 10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14 };
        int s = 2;
        int e = 4;
        partition(arr, s, e);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void partition(int arr[], int s, int e) {
        int i = s + 1;
        int j = e;
        while (i <= j) {
            if (arr[i] <= arr[s]) {
                i++;
            } else if (arr[j] > arr[s]) {
                j--;
            } else {
                Swap(arr, i, j);
                i++;
                j--;
            }
        }

        Swap(arr, s, j);
    }

    // Helper method to swap two elements in the array
    public static void Swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
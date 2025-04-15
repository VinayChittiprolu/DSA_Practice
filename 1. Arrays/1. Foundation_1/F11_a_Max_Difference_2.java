public class F11_a_Max_Difference_2 {
    public static void main(String[] args) {
        int arr[] = { 3, 9, 8, 4, 1 };

        System.out.println(differenceMaxMin(arr));
    }

    public static int differenceMaxMin(int arr[]) {
        // Step 1: Modify each element by adding its index value
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + i;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Step 2: Traverse the array to find the maximum and minimum values
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Update max if current element is greater
            }
            if (arr[i] < min) {
                min = arr[i]; // Update min if current element is smaller
            }
        }

        return max - min; // Step 3: Return the difference between max and min
    }
}
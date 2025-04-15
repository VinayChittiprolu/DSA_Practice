public class F13_Max_Difference_4 {
    public static void main(String[] args) {
        int arr[] = { 3, 9, 8, 4, 1 };

        int x = Max_Differnce_2(arr);
        int y = Max_Differnce_3(arr);

        System.out.println(Math.max(x, y));
    }

    public static int Max_Differnce_2(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + i;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - i;
        }
        return max - min;
    }

    public static int Max_Differnce_3(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - i;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return max - min;
    }
}
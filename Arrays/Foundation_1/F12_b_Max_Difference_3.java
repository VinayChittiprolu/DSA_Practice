public class F12_b_Max_Difference_3 {
    public static void main(String[] args) {
        int arr[] = { 3, 9, 8, 4, 1 };
        
        System.out.println(Max_Diffrence(arr));
    }

    public static int Max_Diffrence(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - i;
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        return max - min;
    }
}
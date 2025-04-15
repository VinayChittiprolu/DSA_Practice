public class L18b_Range_Sum_Query {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        int left = 1;
        int right = 5;

        int[] sum = runningSum(nums);

        if (left == 0) {
            System.out.println(sum[right]);
        } else {
            System.out.println(sum[right] - sum[left - 1]);
        }
    }

    public static int[] runningSum(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        return arr;
    }
}
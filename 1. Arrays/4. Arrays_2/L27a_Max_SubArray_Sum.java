public class L27a_Max_SubArray_Sum {
    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("largest sum is: " + maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j]; // Sum of subarray nums[i...j]
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
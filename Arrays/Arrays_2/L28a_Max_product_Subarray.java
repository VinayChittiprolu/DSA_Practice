public class L28a_Max_product_Subarray {
    public static void main(String[] args) {
        int arr[] = { 2, 3, -2, 4 };
        System.out.println("Maximum Product of Subarray is: " + maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        // Consider every subarray starting from i
        for (int i = 0; i < n; i++) {
            int product = 1;
            // Extend the subarray till j
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }
}
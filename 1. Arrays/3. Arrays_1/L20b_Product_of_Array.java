import java.util.Arrays;

public class L20b_Product_of_Array {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int arr1[] = { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(productExceptSelf(arr)));
        System.out.println(Arrays.toString(productExceptSelf(arr1)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Compute prefix product in `result`
        result[0] = 1; // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Compute the product of all elements to the right and multiply it with
        // the previously computed prefix product
        int rightProduct = 1; // Product of all elements to the right of the current element
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct; // Multiply prefix product by the suffix
            rightProduct *= nums[i]; // Update suffix product
        }

        return result;
    }
}
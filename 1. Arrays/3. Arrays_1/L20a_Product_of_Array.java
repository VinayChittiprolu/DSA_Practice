import java.util.Arrays;

public class L20a_Product_of_Array {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int arr1[] = { -1, 1, 0, -3, 3 };

        System.out.println(Arrays.toString(productExceptSelf(arr)));
        System.out.println(Arrays.toString(productExceptSelf(arr1)));
    }

    public static int[] productExceptSelf(int nums[]) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int pro = 1; // Reset product for each element
            for (int j = 0; j < nums.length; j++) {
                if (j != i) { // Exclude the current element
                    pro *= nums[j];
                }
            }
            ans[i] = pro; // Store the product in the result array
        }
        return ans;
    }
}
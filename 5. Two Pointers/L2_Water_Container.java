public class L2_Water_Container {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("The maximum amount of water a container can store is: " + maxArea(arr));

        int arr1[] = { 1, 1 };
        System.out.println("The maximum amount of water a container can store is: " + maxArea(arr1));
    }

    public static int maxArea(int[] height) {
        // Initialize two pointers
        int i = 0;
        int j = height.length - 1;

        // Initialize maxWater to store the maximum area found
        int maxWater = 0;

        // Loop until the two pointers meet
        while (i < j) {
            // Calculate the width between the two lines and height by taking the minimum of two lines
            int area = (j - i) * (Math.min(height[i], height[j])); // current area (height * width)

            // Update area if the current area is larger
            maxWater = Math.max(maxWater, area);

            // Move the pointer pointing to the shorter line inward
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}
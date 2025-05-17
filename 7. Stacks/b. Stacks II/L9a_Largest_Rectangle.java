public class L9a_Largest_Rectangle {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Area of the largest rectangle: " + largestRectangleArea(arr));

        int arr1[] = { 2, 4 };
        System.out.println("Area of the largest rectangle: " + largestRectangleArea(arr1));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        // Outer loop: fix the starting index of the rectangle
        for (int i = 0; i < n; i++) {
            int minHeight = heights[i]; // Start with the current bar as the minimum height

            // Inner loop: expand the rectangle to the right
            for (int j = i; j < n; j++) {
                int width = j - i + 1; // Width is the number of bars between i and j, inclusive

                minHeight = Math.min(minHeight, heights[j]); // Update the minimum height in the current range [i, j]
                maxArea = Math.max(maxArea, minHeight * width); // Update maxArea if the current area is larger
            }
        }

        return maxArea; // Return the largest area found
    }
}
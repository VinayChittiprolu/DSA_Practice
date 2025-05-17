import java.util.Stack;

public class L9b_Largest_Rectangle {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Area of the largest rectangle: " + largestRectangleArea(arr));

        int arr1[] = { 2, 4 };
        System.out.println("Area of the largest rectangle: " + largestRectangleArea(arr1));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        // Step 1: Get current height
        for (int i = 0; i <= n; i++) {
            int currentHeight;
            if (i < n) {
                currentHeight = heights[i];
            } else {
                currentHeight = 0;
            }

            // While the current bar is smaller than the bar at the top of the stack
            // it means we've found the right boundary of a rectangle for bars in the stack
            while (stack.size() > 0 && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                // Step 2: Calculate width
                int width;
                if (stack.size() == 0) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                // Step 3: Calculate area
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
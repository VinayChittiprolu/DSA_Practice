import java.util.Stack;

public class L10_Maximal_Rectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        System.out.println("The maximal rectangle is: " + maximalRectangle(matrix));

        char[][] matrix1 = { { '0' } };
        System.out.println("The maximal rectangle is: " + maximalRectangle(matrix1));

        char[][] matrix2 = { { '1' } };
        System.out.println("The maximal rectangle is: " + maximalRectangle(matrix2));
    }

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // This array will represent the histogram heights for each column
        int[] heights = new int[col];
        int maxArea = Integer.MIN_VALUE;

        // Process each row of the matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // If current cell is '1', increase the histogram height
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0; // If it's '0', reset the height
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            // Use 0 as a sentinel height at the end
            int currentHeight = (i == n) ? 0 : heights[i];

            while (stack.size() > 0 && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
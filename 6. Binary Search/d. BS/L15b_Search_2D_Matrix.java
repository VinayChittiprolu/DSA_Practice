public class L15b_Search_2D_Matrix {
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 },
        };
        int target = 3;
        System.out.println("Target found: " + searchMatrix(matrix, target));
        System.out.println("Target found: " + searchMatrix(matrix, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value < target) {
                row++;
            } else {
                col--; 
            }
        }
        return false;
    }
}
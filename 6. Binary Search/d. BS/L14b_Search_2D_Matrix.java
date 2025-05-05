public class L14b_Search_2D_Matrix {
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
        int col = (n * m) - 1;

        while (row <= col) {
            int mid = row + (col - row) / 2;

            // [mid / m] gives the row index.
            // [mid % m] gives the column index.
            int midValue = matrix[mid / m][mid % m];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                row = mid + 1;
            } else {
                col = mid - 1;
            }
        }
        return false;
    }
}
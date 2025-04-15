public class L32a_Range_Sum_Query {
    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 0, 1, 4, 2 },
                { 5, 6, 3, 2, 1 },
                { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 }
        };

        // Brute-Force Test
        NumMatrixBruteForce bruteForceMatrix = new NumMatrixBruteForce(matrix);

        System.out.println(bruteForceMatrix.sumRegion(2, 1, 4, 3)); // Output: 8
        System.out.println(bruteForceMatrix.sumRegion(1, 1, 2, 2)); // Output: 11
        System.out.println(bruteForceMatrix.sumRegion(1, 2, 2, 4)); // Output: 12
    }

    public static class NumMatrixBruteForce {
        private int[][] matrix;

        // constructor
        public NumMatrixBruteForce(int[][] matrix) {
            this.matrix = matrix;
        }

        // finding the sum for required range(query)
        public int sumRegion(int row1, int col1, int row2, int col2) {

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
    }
}
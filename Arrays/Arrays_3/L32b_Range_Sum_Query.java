public class L32b_Range_Sum_Query {
   public static void main(String[] args) {
      int[][] matrix = {
            { 3, 0, 1, 4, 2 },
            { 5, 6, 3, 2, 1 },
            { 1, 2, 0, 1, 5 },
            { 4, 1, 0, 1, 7 },
            { 1, 0, 3, 0, 5 }
      };

      NumMatrix numMatrix = new NumMatrix(matrix);

      System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
      System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
      System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
      System.out.println(numMatrix.sumRegion(0, 0, 4, 4));
      System.out.println(numMatrix.sumRegion(0, 0, 0, 0));
   }
}

class NumMatrix {
   private int[][] prefixSum; // Declare a 2D array to store prefix sums

   public NumMatrix(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
         return; // Handle empty or null matrix cases
      }

      int n = matrix.length; // Number of rows
      int m = matrix[0].length; // Number of columns

      prefixSum = new int[n][m]; // Initialize prefixSum array with the same dimensions as the matrix

      // Calculate prefix sum for each row & column
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            if (i == 0 && j == 0) {
               // For the top-left element, the prefix sum is the element itself.
               prefixSum[i][j] = matrix[i][j];
            } else if (i == 0) {
               // For the first row, the prefix sum is the sum of the elements to the left,
               // plus the current element.
               prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j];
            } else if (j == 0) {
               // For the first column, the prefix sum is the sum of the elements above, plus
               // the current element.
               prefixSum[i][j] = prefixSum[i - 1][j] + matrix[i][j];
            } else {
               prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i][j];
               /*
                * For any other element, the prefix sum is calculated as the sum of the prefix sums of the elements above and to the left, minus the prefix sum of the top-left element of the rectangle (to avoiddouble counting), plus the current element.
                */
            }
         }
      }
   }

   // finding the sum for required range(query).
   public int sumRegion(int row1, int col1, int row2, int col2) {
      // 1. Total sum from (0,0) to (row2, col2).
      int sum = prefixSum[row2][col2];

      // 2. Subtract the extra top part (above row1).
      if (row1 > 0) {
         sum -= prefixSum[row1 - 1][col2];
      }

      // 3. Subtract the extra left part (left of col1).
      if (col1 > 0) {
         sum -= prefixSum[row2][col1 - 1];
      }

      // 4. Add the overlap (top-left extra part)
      if (row1 > 0 && col1 > 0) {
         sum += prefixSum[row1 - 1][col1 - 1];
      }

      return sum;
   }
}
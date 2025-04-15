public class L33_Sum_Of_All_Subarrays {
   public static void main(String[] args) {
      int[][] matrix = { { 1, 2 }, { 3, 4 } };

      int n = matrix.length;
      int m = matrix[0].length;

      System.out.println(calculateSubarraySum(matrix, n, m));
   }

   public static int calculateSubarraySum(int[][] matrix, int n, int m) {
      int totalSum = 0;

      // Iterate through each element in the matrix
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            // Calculate the number of times the element contributes to subarrays
            int contribution = (i + 1) * (j + 1) * (n - i) * (m - j);

            // Add the weighted sum to the total sum
            totalSum += (contribution * matrix[i][j]);
         }
      }
      return totalSum;
   }
}
public class L29_Matrix_Transpose {
   public static void main(String[] args) {
      int[][] matrix = {
            { 10, 20, 30, 40 },
            { 50, 60, 70, 80 },
            { 90, 100, 110, 120 },
            { 130, 140, 150, 160 } };

      transposeInPlace(matrix);

      System.out.println("Transpose Matrix:");
      printMatrix(matrix);
   }

   // Transpose the matrix by swapping elements across the diagonal
   private static void transposeInPlace(int[][] matrix) {
      int n = matrix.length;

      for (int row = 0; row < n; row++) {
         for (int col = row; col < n; col++) {
            int temp = matrix[row][col];
            matrix[row][col] = matrix[col][row];
            matrix[col][row] = temp;
         }
      }
   }

   // Print the matrix
   private static void printMatrix(int[][] matrix) {

      for (int row = 0; row < matrix.length; row++) {
         for (int col = 0; col < matrix[row].length; col++) {
            System.out.print(matrix[row][col] + " ");
         }
         
         System.out.println();
      }
   }
}
public class L31_Rotate_Anti_Clock_Wise {
   public static void main(String[] args) {
      int[][] matrix = {
            { 10, 20, 30, 40 },
            { 50, 60, 70, 80 },
            { 90, 100, 110, 120 },
            { 130, 140, 150, 160 } };
      rotate(matrix);

      System.out.println("Anti-Clockwise Rotated Matrix:");
      printMatrix(matrix);
   }

   public static void rotate(int[][] matrix) {
      int n = matrix.length;

      // 1. Transpose the matrix
      for (int row = 0; row < n; row++) {
         for (int col = row; col < n; col++) {
            int temp = matrix[row][col];
            matrix[row][col] = matrix[col][row];
            matrix[col][row] = temp;
         }
      }
      printMatrix(matrix);

      // 2. Flip each clo of transpose matrix
      for (int i = 0; i < n; i++) {
         int sp = 0;
         int ep = n - 1;

         while (sp < ep) {
            int temp = matrix[sp][i];
            matrix[sp][i] = matrix[ep][i];
            matrix[ep][i] = temp;
            sp++;
            ep--;
         }
      }
   }

   // Print the matrix
   public static void printMatrix(int[][] matrix) {

      for (int row = 0; row < matrix.length; row++) {
         for (int col = 0; col < matrix[row].length; col++) {
            System.out.print(matrix[row][col] + " ");
         }

         System.out.println();
      }
   }
}
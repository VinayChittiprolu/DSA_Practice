import java.util.Scanner;

public class F15_Col_wise {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);

      // Input row and column counts
      int n = scn.nextInt();
      int m = scn.nextInt();

      // Declare a 2D array
      int arr[][] = new int[n][m];

      // Input elements of the 2D array
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = scn.nextInt();
         }
      }

      // Print column-wise integers
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            System.out.print(arr[j][i] + " ");
         }
         System.out.println();// Move to the next line after printing each row
      }
      scn.close();
   }
}
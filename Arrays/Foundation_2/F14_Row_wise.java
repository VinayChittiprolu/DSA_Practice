import java.util.Scanner;

public class F14_Row_wise {
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

      // Print row-wise integers
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();// Move to the next line after printing each row
      }
      scn.close();
   }
}
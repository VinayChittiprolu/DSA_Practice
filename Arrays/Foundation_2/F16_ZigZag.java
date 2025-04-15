import java.util.Scanner;

public class F16_ZigZag {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int m = scn.nextInt();

      int arr[][] = new int[n][m];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = scn.nextInt();
         }
      }

      // Print the matrix in a zigzag pattern
      for (int i = 0; i < n; i++) {
         if (i % 2 == 0) { // For even rows (0, 2, 4,...), print left to right
            for (int j = 0; j < m; j++) {
               System.out.print(arr[i][j] + " ");
            }
         } else { // For odd rows (1, 3, 5,...), print right to left
            for (int j = m - 1; j >= 0; j--) {
               System.out.print(arr[i][j] + " ");
            }
         }
         System.out.println(); // Move to the next line after each row
      }

      scn.close(); // Close the Scanner to avoid resource leak
   }
}
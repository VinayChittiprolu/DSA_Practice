public class L22_Range_Addition_HW {
   public static void main(String[] args) {

      int length = 5;
      int[][] updates = {
            { 1, 3, 2 },
            { 2, 4, 3 },
            { 0, 2, -2 } };
      int[] result = new int[length];

      // Apply updates to the result array
      for (int i = 0; i < updates.length; i++) {
         int sp = updates[i][0];
         int ep = updates[i][1];
         int increment = updates[i][2];

         result[sp] += increment;

         if (ep + 1 < length) {
            result[ep + 1] -= increment;
         }
      }

      // Calculate prefix sum
      int[] prefix = new int[length];
      prefix[0] = result[0];
      for (int i = 1; i < length; i++) {
         prefix[i] = prefix[i - 1] + result[i];
      }

      // Print prefix sum
      for (int i = 0; i < length; i++) {
         System.out.print(prefix[i] + " ");
      }
      System.out.println();
   }
}
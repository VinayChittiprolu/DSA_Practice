public class L23_Print_SubArray {
   public static void main(String[] args) {
      int arr[] = { 10, 20, 30, 40, 50 };

      int sp = 1;
      int ep = 3;

      for (int i = sp; i <= ep; i++) {
         System.out.print(arr[i] + " ");
      }
   }
}
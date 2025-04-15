import java.util.Arrays;

public class L38b_Next_Greater_element_3 {
   public static void main(String[] args) {
      int number_0 = 12; // 21
      System.out.println(NextGreaterElement(number_0));

      int number_1 = 97532;
      System.out.println(NextGreaterElement(number_1)); // -1

      int number_2 = 148497532;
      System.out.println(NextGreaterElement(number_2)); // 148523479
   }

   public static int NextGreaterElement(int n) {
      char[] num = (n + "").toCharArray();

      int index = -1;
      for (int i = num.length - 2; i >= 0; i--) {
         if (num[i] < num[i + 1]) {
            index = i;
            break;
         }
      }
      if (index == -1) {
         return -1;
      }

      char value = num[index];
      int small_index = index + 1;

      for (int i = index + 1; i < num.length; i++) {
         if (num[i] > value && num[i] <= num[small_index]) {
            small_index = i;
         }
      }

      char temp = num[index];
      num[index] = num[small_index];
      num[small_index] = temp;

      Arrays.sort(num, index + 1, num.length);
      long ans = Long.parseLong(new String(num));
      if (ans > Integer.MAX_VALUE) {
         return -1;
      } else {
         return (int) ans;
      }
   }
}
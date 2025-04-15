public class F1_sum_of_Array {
  public static void main(String[] args) {
    int arr[] = { 10, 2, 31, 6, 1 };

    System.out.println("Sum of an Array: " + sumArray(arr));
  }

  public static int sumArray(int arr[]) {
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum = sum + arr[i];
    }
    return sum;
  }
}
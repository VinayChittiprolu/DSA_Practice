import java.util.Stack;

public class L7_NGE_Left_Array {
    public static void main(String[] args) {
        int[] arr = { 3, 8, 5, 2, 25 };
        printArray(helpClassmate(arr));

        int[] arr1 = { 1, 2, 3, 4 };
        printArray(helpClassmate(arr1));
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] helpClassmate(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (stack.size() > 0) {
            result[stack.pop()] = -1;
        }

        return result;
    }
}
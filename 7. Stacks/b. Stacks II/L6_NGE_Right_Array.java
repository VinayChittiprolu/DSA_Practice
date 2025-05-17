import java.util.Stack;

public class L6_NGE_Right_Array {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        printArray(nextLargerElement(arr));

        int[] arr1 = { 6, 8, 0, 1, 3 };
        printArray(nextLargerElement(arr1));
    }

    // Utility method to print Array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] nextLargerElement(int[] arr) {
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        // Iterate through the input array
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = arr[i];
            }
            stack.push(i);
        }

        // After processing all elements, if there are elements left in the stack
        while (stack.size() > 0) {
            int index = stack.pop();
            result[index] = -1; // indicating no greater element to the right
        }

        return result;
    }
}
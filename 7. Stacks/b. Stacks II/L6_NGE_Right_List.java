import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class L6_NGE_Right_List {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        System.out.println((nextLargerElement(arr)));

        int[] arr1 = { 6, 8, 0, 1, 3 };
        System.out.println((nextLargerElement(arr1)));
    }

    public static List<Integer> nextLargerElement(int[] arr) {
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

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            int index = result[i];
            output.add(index);
        }
        return output;
    }
}
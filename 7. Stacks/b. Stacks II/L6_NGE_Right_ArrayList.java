import java.util.ArrayList;
import java.util.Stack;

public class L6_NGE_Right_ArrayList {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        printArrayList(nextLargerElement(arr));

        int[] arr1 = { 6, 8, 0, 1, 3 };
        printArrayList(nextLargerElement(arr1));
    }

    // Utility method to print ArrayList<Integer>
    public static void printArrayList(ArrayList<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        // Initialize a stack to keep track of indices
        Stack<Integer> stack = new Stack<>();

        // Initialize an array to store the results
        int result[] = new int[arr.length];

        // Iterate through the input array
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        // After processing all elements, if there are elements left in the stack
        while (stack.size() > 0) {
            result[stack.pop()] = -1; // indicating no greater element to the right
        }

        // Convert the result array to ArrayList
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            int ele = result[i];
            output.add(ele);
        }

        return output;
    }
}
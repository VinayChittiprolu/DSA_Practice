import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L8_NSE_Left_List {
    public static void main(String[] args) {
        int[] arr = { 1, 6, 3 };
        System.out.println(leftSmaller(arr));

        int[] arr1 = { 1, 5, 0, 3, 4, 5 };
        System.out.println(leftSmaller(arr1));
    }

    public static List<Integer> leftSmaller(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (stack.size() > 0) {
            result[stack.pop()] = -1;
        }

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            output.add(result[i]);
        }

        return output;
    }
}
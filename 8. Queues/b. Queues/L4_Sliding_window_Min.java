import java.util.ArrayDeque;
import java.util.Deque;

public class L4_Sliding_window_Min {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 2, 5, 1 }; // 2 2 1
        int k = 3;

        int result[] = minSlidingWindow(arr, k);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static int[] minSlidingWindow(int[] num, int k) {
        int n = num.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        // Processing the first sliding window
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() > num[i]) {
                deque.removeLast();
            }
            deque.addLast(num[i]);
        }

        // Storing the minimum value of the first sliding window
        ans[0] = deque.getFirst();

        // Processing subsequent sliding windows
        for (int i = k; i < n; i++) {
            // Removing the element that falls out of the sliding window
            if (num[i - k] == deque.getFirst()) {
                deque.removeFirst();
            }

            // Removing elements from the end of the deque until it's empty or contains
            // elements greater than or equal to the current element
            while (!deque.isEmpty() && deque.getLast() > num[i]) {
                deque.removeLast();
            }
            deque.addLast(num[i]);

            // Storing the minimum value of the current sliding window
            ans[i - k + 1] = deque.getFirst();
        }
        return ans;
    }
}
import java.util.ArrayDeque;
import java.util.Deque;

public class L3_Sliding_Window_Max {
    public static void main(String args[]) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        int result[] = maxSlidingWindow(arr, k);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] num, int k) {
        int n = num.length;
        int[] ans = new int[n - k + 1]; // Output array to store the max of each window
        Deque<Integer> deque = new ArrayDeque<>(); // Deque to store elements in decreasing order

        // Process the first window of size k
        for (int i = 0; i < k; i++) {
            // Remove elements smaller than the current one from the back of the deque
            while (!deque.isEmpty() && deque.getLast() < num[i]) {
                deque.removeLast();
            }
            // Add the current element to the deque
            deque.addLast(num[i]);
        }

        // The front of the deque is the maximum for the first window
        ans[0] = deque.getFirst();

        // Process the rest of the array
        for (int i = k; i < n; i++) {
            // If the element that is sliding out is the maximum, remove it from the front
            if (num[i - k] == deque.getFirst()) {
                deque.removeFirst();
            }

            // Remove all elements smaller than the current one from the back
            while (!deque.isEmpty() && deque.getLast() < num[i]) {
                deque.removeLast();
            }

            // Add the current element to the deque
            deque.addLast(num[i]);

            // The front of the deque is the maximum for the current window
            ans[i - k + 1] = deque.getFirst();
        }

        return ans;
    }
}
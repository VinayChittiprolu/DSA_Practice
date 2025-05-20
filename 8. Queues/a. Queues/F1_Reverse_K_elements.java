import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class F1_Reverse_K_elements {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(3);
        q.add(10);
        q.add(2);
        q.add(12);
        q.add(19);
        q.add(6);
        q.add(8);
        q.add(10);
        q.add(14);
        q.offer(2);  // safer than add()
        System.out.println("Input: " + q);

        System.out.println("Output: " + ModifyQueue(q, 5));
        System.out.println(q.poll()); // removes head, returns null if empty
    }

    public static Queue<Integer> ModifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = q.size();

        // Step 1: Push the first k elements onto the stack
        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }

        // Step 2: Enqueue the elements from the stack back into the queue
        for (int i = 0; i < k; i++) {
            q.add(stack.pop());
        }

        // Step 3: Rotate the first k elements in the queue
        for (int i = 0; i < n - k; i++) {
            q.add(q.remove());
        }

        return q;
    }
}
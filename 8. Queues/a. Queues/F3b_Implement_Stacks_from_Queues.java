import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class F3b_Implement_Stacks_from_Queues {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(1);
        myStack.push(2);

        System.out.println(myStack.peek()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }

    class MyStack {
        private Queue<Integer> mainQ; // Main queue
        private Queue<Integer> helperQ; // Temporary queue

        // Constructor: Initializes the two queues.
        public MyStack() {
            mainQ = new LinkedList<>();
            helperQ = new LinkedList<>();
        }

        public void push(int x) {
            // Step 1: Enqueue x into helperQ
            helperQ.offer(x);

            // Step 2: Move all elements from mainQ to helperQ
            while (!mainQ.isEmpty()) {
                helperQ.offer(mainQ.poll());
            }

            // Step 3: Swap mainQ and helperQ
            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;
        }

        public int pop() {
            if (mainQ.isEmpty()) {
                return -1; // Stack is empty
            }
            return mainQ.poll(); // Front of mainQ is the top of the stack
        }

        public int top() {
            if (mainQ.isEmpty()) {
                return -1; // Stack is empty
            }
            return mainQ.peek(); // Peek the front of mainQ
        }

        public boolean empty() {
            return mainQ.isEmpty();
        }
    }
}
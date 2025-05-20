import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class F3a_Implement_Stacks_from_Queues {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(1);
        myStack.push(2);

        System.out.println(myStack.peek()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        q.add(x); // Enqueue new element
        for (int i = 1; i <= q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    // Removes the element on top of the stack.
    public int pop() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.remove(); // Front element is the top of the stack
    }

    // Get the top element.
    public int top() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
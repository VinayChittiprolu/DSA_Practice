import java.util.Stack;

public class F2_Implement_Queue_from_Stack {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        // Enqueue elements: 5, 4, 7, 9
        q.push(5);
        q.push(4);
        q.push(7);
        q.push(9);

        // Dequeue and print the first two elements: should print 5 and 4
        System.out.println(q.pop());
        System.out.println(q.pop());

        // Enqueue more elements: 8, 10
        q.push(8);
        q.push(10);

        // Dequeue and print two more elements: should print 7 and 9
        System.out.println(q.pop());
        System.out.println(q.pop());

        // Enqueue one more element: 14
        q.push(14);

        // Dequeue and print the remaining elements: should print 8, 10, 14
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

        // Check if the queue is empty: should print true
        System.out.println(q.empty());
    }
}

class MyQueue {
    Stack<Integer> inputStack; // For enqueuing (push)
    Stack<Integer> outputStack; // For dequeuing (pop/peek)

    // Constructor: Initializes the two stacks.
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // Enqueue operation: Add element to the back of the queue
    public void push(int x) {
        inputStack.push(x); // Always push new elements into inputStack
    }

    // Dequeue operation: Remove and return the front element of the queue
    public int pop() {
        shiftStacksIfNeeded();

        if (outputStack.isEmpty()) {
            return -1; // Queue is empty
        }
        return outputStack.pop(); // Return the front element
    }

    public int peek() {
        shiftStacksIfNeeded();

        if (outputStack.isEmpty()) {
            return -1; // Queue is empty
        }

        return outputStack.peek(); // Return the front element
    }

    // Check if the queue is empty
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // Helper method to transfer elements from inputStack to outputStack if needed
    private void shiftStacksIfNeeded() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop()); // Reverse order of elements
            }
        }
    }
}
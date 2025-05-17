import java.util.Stack;

class L14b_Min_Stack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println(minStack.top()); // Output: 0
        System.out.println(minStack.getMin()); // Output: -2
    }

    public static class MinStack {
        Stack<Long> stack; // Stores modified values (not the actual values directly)
        long minStack; // Tracks the current minimum element

        public MinStack() {
            stack = new Stack<>();
            minStack = Long.MAX_VALUE;
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                minStack = val;
                stack.push(0L);
                return;
            }

            long diff = val - minStack;
            stack.push(diff);
            if (val < minStack) {
                minStack = val;
            }
        }

        public void pop() {
            long rem = stack.pop();
            if (stack.isEmpty()) {
                return;
            }

            if (rem < 0) {
                minStack = minStack - rem; // Restore the previous min
            }
        }

        public int top() {
            long rem = stack.peek();
            if (stack.isEmpty()) {
                return -1; // or throw an exception
            }

            if (rem < 0) {
                return (int) minStack; // min is the actual top
            } else {
                return (int) (minStack + rem); // restore original value
            }
        }

        public int getMin() {
            if (stack.isEmpty()) {
                return -1; // or throw an exception
            }
            return (int) minStack;
        }
    }
}
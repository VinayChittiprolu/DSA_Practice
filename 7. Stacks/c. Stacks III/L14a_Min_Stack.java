import java.util.Stack;

class L14a_Min_Stack {
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
        Stack<Integer> minStack; // Stack to store the current minimum value at each level of the main stack
        Stack<Integer> stack; // Stack to store all the values

        // Constructor to initialize both stacks
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        // Pushes a value onto the stack
        public void push(int val) {
            // Always push the value onto the main stack
            stack.push(val);

            // If minStack is empty, push the value as the current minimum
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                // Otherwise, compare with the current minimum and push the smaller one
                minStack.push(Math.min(val, minStack.peek()));
            }
        }

        // Removes the top value from both stacks
        public void pop() {
            stack.pop();
            minStack.pop();
        }

        // Returns the top value of the main stack
        public int top() {
            return stack.peek();
        }

        // Returns the current minimum value in the stack
        public int getMin() {
            return minStack.peek();
        }
    }
}
import java.util.Stack;

public class F5_Asteriod_Collision {
    public static void main(String[] args) {
        int[] asteroids = { 5, 10, -5 };
        printArray(asteroidCollision(asteroids));

        int[] asteroids1 = { 8, -8 };
        printArray(asteroidCollision(asteroids1));

        int[] asteroids2 = { 10, 2, -5 };
        printArray(asteroidCollision(asteroids2));
    }

    private static void printArray(int ans[]) {
        System.out.print("Surviving asteroids: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); // Stack to store surviving asteroids
        int i = 0;

        while (i < asteroids.length) {
            // Case 1: asteroid is moving right, or stack is empty, or top of stack is
            // moving left
            if (asteroids[i] > 0 || stack.empty() || stack.peek() < 0) {
                stack.push(asteroids[i]); // No collision possible, push current asteroid
                i++;
            }
            // Case 2: top of stack and current asteroid are equal in size and opposite
            // directions
            else if (stack.peek() == -asteroids[i]) {
                stack.pop(); // Both asteroids destroy each other
                i++;
            }
            // Case 3: top of stack is smaller (moving right), current asteroid is bigger
            // (moving left)
            else if (stack.peek() < -asteroids[i]) {
                stack.pop(); // Top asteroid explodes, check again with new top of stack (don't increment i)
            }
            // Case 4: top of stack is larger, current asteroid is destroyed
            else {
                i++; // Current asteroid is destroyed, move to next one
            }
        }

        // Convert surviving asteroids in stack to an array
        int[] result = new int[stack.size()];
        for (int j = result.length - 1; j >= 0; j--) {
            result[j] = stack.pop(); // Pop elements from stack to get correct order
        }
        return result;
    }
}
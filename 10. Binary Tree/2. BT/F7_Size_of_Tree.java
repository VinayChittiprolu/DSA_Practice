import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class F7_Size_of_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = null; // NULL is represented by null
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println("Size of the BT: " + getSize1(root));
        System.out.println("Size of the BT: " + getSize2(root));
        System.out.println("Size of the BT: " + getSize3(root));
    }

    // Recursive approach
    public static int getSize1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getSize1(root.left);
        int right = getSize1(root.right);

        return left + right + 1;
    }

    // Iterative approach using BFS
    public static int getSize2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // Get the front node
            count++;

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return count;
    }

    // DFS iterative version
    public static int getSize3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop(); // Get the top node
            count++;

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return count;
    }
}
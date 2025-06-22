import java.util.LinkedList;
import java.util.Queue;

public class F8_Sum_of_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = null; // NULL is represented by null
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println("Sum of the BT using RCS: " + getSum(root));
        System.out.println("Sum of the BT using BFS: " + getSumBFS(root));
        System.out.println("Sum of the BT using DFS: " + getSumDFS(root));
    }

    public static int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getSum(root.left);
        int right = getSum(root.right);

        return left + right + root.val;
    }

    // Iterative approach using BFS
    public static int getSumBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // Get the front node
            sum += current.val;

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return sum;
    }

    // DFS iterative version
    public static int getSumDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            sum += current.val;

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return sum;
    }
}
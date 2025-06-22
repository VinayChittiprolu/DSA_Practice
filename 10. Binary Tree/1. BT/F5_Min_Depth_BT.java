import java.util.LinkedList;
import java.util.Queue;

public class F5_Min_Depth_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(minDepth(root));
        System.out.println(minHeight(root));
    }

    // Recursive approach to find the minimum depth of a binary tree
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return Math.min(left, right) + 1;
    }

    // Iterative-BFS approach to find the minimum height of a binary tree using
    // level order traversal
    public static int minHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Using a queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        // Level order traversal
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode current = queue.remove();

                // If a leaf node is found just return depth
                if (current.left == null && current.right == null) {
                    return depth;
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            depth++; // one level completed
        }
        return depth;
    }
}
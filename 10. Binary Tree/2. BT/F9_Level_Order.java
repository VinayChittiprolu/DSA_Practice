import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class F9_Level_Order {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);
        root.right.right.left = new TreeNode(12);
        root.right.right.right = new TreeNode(13);

        List<List<Integer>> result = levelOrder(root);

        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

    // Given a binary tree, return its level order traversal as a list of lists
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(n) for the queue used in level order traversal
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>(); // Initialize the result list

        if (root == null) {
            return result;
        }

        // Using a queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start with the root node

        while (!queue.isEmpty()) {
            int n = queue.size(); // Store the size before the loop
            List<Integer> temp = new LinkedList<>(); // Temporary list to hold values of the current level

            for (int i = 0; i < n; i++) {
                TreeNode current = queue.remove(); // Remove the front node from the queue
                temp.add(current.val); // Add the value of the current node to the temporary list

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);

            }
            // After processing all nodes at the current level, add the temporary list to
            // the result
            result.add(temp);
        }
        // Return the final result containing all levels
        return result;
    }

    // Given a binary tree, print its level order traversal
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(n) for the queue used in level order traversal
    public static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        if (root == null) {
            return;
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.remove();
                System.out.print(current.val + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            System.out.println();
        }
    }
}
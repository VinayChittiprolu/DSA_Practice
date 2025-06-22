import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class F12_Reverse_Odd_Level_Order_ {
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

        TreeNode modifiedRoot = reverseOddLevels(root); // Call the method to reverse odd levels
        List<List<TreeNode>> result = levelOrder(modifiedRoot); // Get the level order traversal of the modified tree

        for (List<TreeNode> level : result) {
            List<Integer> values = new LinkedList<>();
            for (TreeNode node : level) {
                values.add(node.val); // Collect values for printing
            }
            System.out.println(values); // Print the values of the current level
        }
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        List<List<TreeNode>> tree = levelOrder(root); // Get the level order traversal of the tree
        int level = 0; // Initialize the level counter

        for (List<TreeNode> values : tree) {
            if (level % 2 == 1) { // Check if the current level is odd
                int left = 0;
                int right = values.size() - 1;

                // Swap values in the list for odd levels
                while (left < right) {
                    int temp = values.get(left).val;
                    values.get(left).val = values.get(right).val;
                    values.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            level++; // Increment the current level for the next iteration
        }
        return root; // Return the modified tree
    }

    public static List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> result = new LinkedList<>(); // Initialize the result list

        if (root == null) {
            return result;
        }

        // Using a queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start with the root node

        while (!queue.isEmpty()) {
            int n = queue.size(); // Store the size before the loop
            List<TreeNode> temp = new LinkedList<>(); // Temporary list to hold nodes of the current level

            for (int i = 0; i < n; i++) {
                TreeNode current = queue.remove(); // Remove the front node from the queue
                temp.add(current); // Add the current node to the temporary list

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
}
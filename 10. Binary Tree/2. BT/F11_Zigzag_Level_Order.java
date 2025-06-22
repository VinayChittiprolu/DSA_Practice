import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class F11_Zigzag_Level_Order {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>(); // Result list to hold the zigzag level order traversal
        if (root == null) {
            return result;
        }

        // Queue to hold nodes for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();
            // Temporary list to hold values of the current level
            List<Integer> temp = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                // Remove the current node from the queue
                TreeNode current = queue.remove();
                // Add the current node's value to the temporary list
                if (level % 2 == 0) {
                    temp.addLast(current.val);
                } else {
                    temp.addFirst(current.val);
                }

                // Add child nodes (left then right) to the queue for the next level
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);

            }
            level++;
            result.add(temp); // Add the temporary list to the result list
        }
        return result;
    }
}
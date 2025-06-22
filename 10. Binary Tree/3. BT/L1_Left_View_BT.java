import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L1_Left_View_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(leftSide(root));
    }

    public static ArrayList<Integer> leftSide(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); // Create an empty queue to store tree nodes
        queue.add(root); // Add the root node to the queue (start with the top level)

        ArrayList<Integer> result = new ArrayList<>(); // to store the leftmost nodes.
        if (root == null) {
            return result;
        }

        // Loop as long as the queue is not empty
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove(); // Remove the first node from the queue

                if (i == 0) {
                    result.add(node.val); // value of the removed node (left node)
                }

                // Add the left and right child of the removed node to the queue (if it exists)
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                queue.add(node.right);
                }
            }
        }
        return result;
    }
}
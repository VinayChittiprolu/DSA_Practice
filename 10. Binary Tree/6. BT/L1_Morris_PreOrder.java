import java.util.ArrayList;
import java.util.List;

public class L1_Morris_PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> preOrder = preOrderTraversal(root);
        System.out.println("Morris PreOrder Traversal: " + preOrder);
    }

    // Morris (Iterative)
public static List<Integer> preOrderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode current = root;

    while (current != null) {
        if (current.left == null) {
            // No left child, add root value and move to the right child
            result.add(current.val);
            current = current.right;
        } else {
            // Find the predecessor
            TreeNode pre = current.left;
            while (pre.right != null && pre.right != current) {
                pre = pre.right;
            }

            if (pre.right == null) {
                // Establish the link back to the root
                pre.right = current;
                // Add root value and move to the left child
                result.add(current.val);
                current = current.left;
            } else {
                // Remove the link and move to the right child
                pre.right = null;
                current = current.right;
            }
        }
    }
    return result;
}
}
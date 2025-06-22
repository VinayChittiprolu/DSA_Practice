import java.util.LinkedList;
import java.util.Queue;

public class L1_Delete_Node_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int key = 3;
        System.out.println("Original Tree");
        levelOrder(root);

        System.out.println("After deleting " + key);
        levelOrder(deleteNode(root, key));
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        if (root == null) {
            return;
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.remove();

                if (node != null) {
                    System.out.print(node.val + " ");
                    q.add(node.left);
                    q.add(node.right);
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        // Base case: if the root is null, return null
        if (root == null) {
            return null;
        }

        // If the key to be deleted is smaller than the root's key,
        // then it lies in the left subtree
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        // If the key to be deleted is greater than the root's key,
        // then it lies in the right subtree
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        // If the key is the same as the root's key, this is the node to be deleted
        else {
            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children
            // Get the in-order predecessor (maximum value in the left subtree)
            int max = findMax(root.left);

            // Replace the root's value with the in-order predecessor's value
            root.val = max;

            // Delete the in-order predecessor
            root.left = deleteNode(root.left, max);
        }

        // Return the (potentially modified) root
        return root;
    }

    // Helper function to find the maximum value node in a BST
    public static int findMax(TreeNode root) {
        // Loop to find the rightmost leaf
        while (root.right != null) {
            root = root.right;
        }
        // Return the maximum value found
        return root.val;
    }
}
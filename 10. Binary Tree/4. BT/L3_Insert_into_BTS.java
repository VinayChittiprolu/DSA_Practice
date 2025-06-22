import java.util.LinkedList;
import java.util.Queue;

public class L3_Insert_into_BTS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 5;

        System.out.println("Original BST");
        PrintLevelOrder(root);

        root = insertIntoBST(root, val);
        System.out.println("Final BST after inserting " + val);
        PrintLevelOrder(root);
    }

    // Helper method to print the tree (Level-order Traversal)
    public static void PrintLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        if (root == null) {
            return;
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                System.out.print(node.val + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }

    // Recursive approach to insert a value into a Binary Search Tree (BST)
    // Time Complexity: O(h) where h is the height of the tree
    // Space Complexity: O(h) for the recursion stack
    public static TreeNode REC_insertIntoBST(TreeNode root, int val) {
        // Base case: if we reach a null node, create and return new node
        if (root == null) {
            return new TreeNode(val);
        }

        // Recursive case: decide whether to go left or right
        if (val < root.val) {
            // Insert in left subtree
            root.left = REC_insertIntoBST(root.left, val);
        } else {
            // Insert in right subtree (val >= root.val)
            root.right = REC_insertIntoBST(root.right, val);
        }

        // Return the unchanged root
        return root;
    }

    // Iterative approach to insert a value into a Binary Search Tree (BST)
    // Time Complexity: O(h) where h is the height of the tree
    // Space Complexity: O(1) since we are not using recursion
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val); // Create a new node with the given value
        if (root == null) { // If the tree is empty, return the new node as the root
            return newNode;
        }

        TreeNode current = root; // Store the original root to return later

        // Traverse the tree to find the correct position for the new node
        while (true) {

            if (root.val > val) {
                // If the value is less than the current node's value, go left
                if (root.left == null) {
                    root.left = newNode;
                    break;
                } else { // If the left child exists, move to the left child
                    root = root.left;
                }
            } else {
                // If the value is greater than or equal to the current node's value, go right
                if (root.right == null) {
                    root.right = newNode;
                    break;
                } else { // If the right child exists, move to the right child
                    root = root.right;
                }
            }
        }
        return current; // Return the original root of the tree
    }
}
public class L2_InOrder_Successor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);

        // Example node whose successor we want to find
        TreeNode x = root.left.right; // node with value 15

        TreeNode successor = inOrderSuccessor(root, x);

        if (successor != null) {
            System.out.println("In-order Successor of " + x.val + " is " + successor.val);
        } else {
            System.out.println("In-order Successor of " + x.val + " does not exist.");
        }
    }

    public static TreeNode inOrderSuccessor(TreeNode root, TreeNode x) {
        // Case 1: If the node has a right child, the successor is the leftmost node
        if (x.right != null) {
            TreeNode current = x.right; // Start with the right child

            while (current.left != null) {
                current = current.left; // Traverse to the leftmost node
            }
            return current;
        }

        // Case 2: If the node does not have a right child, find the successor in the
        // tree
        TreeNode successor = null; // Initialize successor as null
        while (root != null) {
            if (x.val < root.val) {
                successor = root; // Potential successor
                root = root.left; // Move left
            } else {
                root = root.right; // Move right
            }
        }
        return successor; // Return the in-order successor
    }
}
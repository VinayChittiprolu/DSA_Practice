public class F7_Balanced_BT {
    // O(n^2) approach
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        // All three conditions must be true for balance
        return Math.abs(left - right) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

// Helper function to calculate height of a tree
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }

    // O(n), post-order DFS traversal - recommended for interviews
    public static boolean isBalancedOptimized(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode root) {
        if (root == null) {
            return 0; // height of null tree is 0
        }

        // Check left subtree
        int left = checkBalance(root.left);
        if (left == -1) {
            return -1; // Left subtree is unbalanced
        }

        // Check right subtree
        int right = checkBalance(root.right);
        if (right == -1) {
            return -1; // Right subtree is unbalanced
        }

        // Check current node balance
        if (Math.abs(left - right) > 1) {
            return -1; // Current node is unbalanced
        }

        // Return height of current subtree
        return Math.max(left, right) + 1;
    }

    // Test case
    public static void main(String[] args) {
        // Tree: [2,null,3,null,4,null,5,null,6]
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);

        System.out.println("O(n^2) approach: " + isBalanced(root)); // false
        System.out.println("O(n) approach: " + isBalancedOptimized(root)); // false
        System.out.println("O(n) approach: " + checkBalance(root)); // false
    }
}
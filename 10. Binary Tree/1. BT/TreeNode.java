public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Default constructor
    TreeNode() {
    }

    // Constructor with value
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor with value and left/right children
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
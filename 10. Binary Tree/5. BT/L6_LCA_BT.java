public class L6_LCA_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        int p = 2;
        int q = 8;

        TreeNode LCA = lca(root, p, q);
        System.out.println("The lowest common ancestor is: " + LCA.val);
    }

    public static TreeNode lca(TreeNode root, int n1, int n2) {
        // Base case: If the current node is null, there's no LCA in this subtree
        if (root == null) {
            return null;
        }

        // Check if the current node itself is the LCA (either n1 or n2)
        if (root.val == n1 || root.val == n2) {
            return root;
        }

        // Recursively search for LCA in the left subtree
        TreeNode left = lca(root.left, n1, n2);
        // Recursively search for LCA in the right subtree
        TreeNode right = lca(root.right, n1, n2);

        // If LCA is found in both left and right subtrees, it means the current node is LCA
        if (left != null && right != null) {
            return root;
        }

        // If LCA is found only in the left subtree, return the left node
        if (left != null) {
            return left;
        }

        // If LCA is found only in the right subtree, return the right node
        return right;
    }
}
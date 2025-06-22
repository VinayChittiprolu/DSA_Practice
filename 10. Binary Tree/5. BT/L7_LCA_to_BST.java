public class L7_LCA_to_BST {
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

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8

        TreeNode LCA = lowestCommonAncestor(root, p, q);
        System.out.println("The lowest common ancestor is: " + LCA.val);

        TreeNode LCA_REC = lowestCommonAncestorRecursive(root, p, q);
        System.out.println("The lowest common ancestor is: " + LCA_REC.val);
    }

    // Iterative version of the LCA function
    // TC: O(h) where h is the height of the tree
    // SC: O(1) for the iterative approach (no extra space used)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Loop until we find the LCA or reach a null node
        while (root != null) {
            // If both p and q are on the left side of the current node
            if (p.val < root.val && q.val < root.val) {
                // Move left to search for the LCA in the left subtree
                root = root.left;
            }
            // If both p and q are on the right side of the current node
            else if (p.val > root.val && q.val > root.val) {
                // Move right to search for the LCA in the right subtree
                root = root.right;
            }
            // If one node is on the left and the other on the right, or if either p or q is
            // equal to the current node, then the current node is the LCA
            else {
                return root; // The current node is the LCA
            }
        }

        // If we reach here, it means p and q are not present in the tree
        return null;
    }

    // Recursive version of the LCA function
    // TC: O(h) where h is the height of the tree
    // SC: O(h) for the recursive stack space
    public static TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the current node is null, return null
        if (root == null) {
            return null;
        }
        // If both p and q are on the left side of the current node
        if (p.val < root.val && q.val < root.val) {
            // Recursively search for LCA in the left subtree
            return lowestCommonAncestorRecursive(root.left, p, q);
        }
        // If both p and q are on the right side of the current node
        else if (p.val > root.val && q.val > root.val) {
            // Recursively search for LCA in the right subtree
            return lowestCommonAncestorRecursive(root.right, p, q);
        }
        // If one node is on the left and the other on the right, or if either
        // p or q is equal to the current node, then the current node is the LCA
        else {
            return root; // The current node is the LCA
        }
    }
}
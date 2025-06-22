public class L1_Search_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode resultRec = searchBST_REC(root, 2);
        System.out.println("Value Found: " + (resultRec != null ? resultRec.val : "Not Found"));

        TreeNode resultIter = searchBST(root, 30);
        System.out.println("Value Found: " + (resultIter != null ? resultIter.val : "Not Found"));
    }

    // Recursive search in a Binary Search Tree (BST)
    public static TreeNode searchBST_REC(TreeNode root, int val) {
        // Base case: reached null or found the target
        if (root == null || root.val == val) {
            return root;
        }

        // If target is smaller, search left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            // If target is larger, search right subtree
            return searchBST(root.right, val);
        }
    }

    // Iterative search in a Binary Search Tree (BST)
    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
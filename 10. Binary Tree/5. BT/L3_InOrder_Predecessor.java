public class L3_InOrder_Predecessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);

        // Example node whose predecessor we want to find
        TreeNode x = root.left.right; // node with value 15

        int predecessor = inOrderPredecessor(root, x);

        if (predecessor != -1) {
            System.out.println("In-order predecessor of " + x.val + " is " + predecessor);
        } else {
            System.out.println("In-order predecessor of " + x.val + " does not exist.");
        }
    }

    public static int inOrderPredecessor(TreeNode root, TreeNode x) {
        if (x.left != null) {
            TreeNode curr = x.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            return curr.val;
        }

        TreeNode predecessor = null;
        while (root != null) {
            if (x.val > root.val) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return (predecessor != null) ? predecessor.val : -1;
    }
}
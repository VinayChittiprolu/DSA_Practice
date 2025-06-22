public class L2_Validate_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println("Is Valid Tree: " + isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        boolean left = validate(root.left, min, root.val);
        boolean right = validate(root.right, root.val, max);

        return left && right;
    }
}
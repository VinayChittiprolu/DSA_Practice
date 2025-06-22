public class L3_BT_Camera {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(0);

        System.out.println(minCameraCover(root));
    }

    private static int cam = 0;

    public static int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            cam++; // If the root needs a camera (subtree not covered), add one
        }

        return cam;
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 2; // Empty subtree, doesn't need a camera
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            cam++; // Add camera if a child needs coverage
            return 1; // Current node has a camera
        }

        if (left == 1 || right == 1) {
            return 2; // No camera needed on current node, child can cover
        }

        return 0; // Both children are covered, no camera needed here
    }
}
public class F6_Diameter_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);

        System.out.println(diameterOfBinaryTree(root));
    }

    public static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        // include +1 in math.max for no. of edges
        maxDiameter = Math.max(maxDiameter, left + right); 
        return Math.max(right, left) + 1;
    }
}
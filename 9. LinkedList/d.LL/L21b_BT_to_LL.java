public class L21b_BT_to_LL {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        printList(root);
    }

    public static void printList(TreeNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.right;
        }
        System.out.println("null");
    }

    // public static TreeNode flatten(TreeNode root) {
    // if (root == null)
    // return null;

    // flatten(root.left);
    // flatten(root.right);

    // TreeNode left = root.left;
    // TreeNode right = root.right;

    // if (left != null) {
    // root.right = left;
    // root.left = null;

    // // Find the tail of the flattened left subtree
    // TreeNode tail = left;
    // while (tail.right != null) {
    // tail = tail.right;
    // }

    // // Attach original right subtree to tail
    // tail.right = right;
    // }

    // return root;
    // }

    private static TreeNode prev = null;

    public static void flatten(TreeNode root) {
        if (root == null)
            return;

        // Recurse right subtree first
        flatten(root.right);
        // Recurse left subtree next
        flatten(root.left);

        // Link current node
        root.right = prev;
        root.left = null;

        // Update prev to current node
        prev = root;
    }

}
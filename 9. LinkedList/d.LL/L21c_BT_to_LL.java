public class L21c_BT_to_LL {
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
        System.out.println();
    }

    public static void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // Connect the right subtree to the right of the predecessor
                predecessor.right = current.right;

                // Move left subtree to the right and nullify the left
                current.right = current.left;
                current.left = null;
            }

            // Move to the next node (always right)
            current = current.right;
        }
    }
}
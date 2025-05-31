import java.util.ArrayList;
import java.util.List;

public class L21a_BT_to_LL {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        // Step 1: Pre-order traversal to collect nodes
        List<TreeNode> nodeList = new ArrayList<>();
        preOrder(root, nodeList);

        // Step 2: Relink nodes
        for (int i = 0; i < nodeList.size() - 1; i++) {
            TreeNode curr = nodeList.get(i);
            TreeNode next = nodeList.get(i + 1);
            curr.left = null;
            curr.right = next;
        }
    }

    private void preOrder(TreeNode node, List<TreeNode> nodeList) {
        if (node == null)
            return;
        nodeList.add(node);
        preOrder(node.left, nodeList);
        preOrder(node.right, nodeList);
    }

    public static void printList(TreeNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        L21a_BT_to_LL solution = new L21a_BT_to_LL();
        solution.flatten(root);
        printList(root);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
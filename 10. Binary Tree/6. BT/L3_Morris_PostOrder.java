import java.util.ArrayList;
import java.util.List;

public class L3_Morris_PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> postOrder = postOrderTraversal(root);
        System.out.println("Morris PostOrder Traversal: " + postOrder);
    }

    // Morris PostOrder Traversal
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode current = dummy;

        while (current != null) {
            if (current.left == null) {
                current = current.right;
            } else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    addReversePath(current.left, result);
                    current = current.right;
                }
            }
        }
        return result;
    }

    private static void addReversePath(TreeNode node, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            temp.add(node.val);
            node = node.right;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }
}
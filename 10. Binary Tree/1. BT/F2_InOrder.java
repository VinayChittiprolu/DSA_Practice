import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class F2_InOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Recursive In-order: " + recursive1(root));
        System.out.println("Recursive In-order: " + recursive2(root));
        System.out.println("Iterative In-order: " + iterative(root));
    }

    // Recursive In-order Traversal of a Binary Tree - Less Efficient
    public static List<Integer> recursive1(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.addAll(recursive1(root.left));
        list.add(root.val);
        list.addAll(recursive1(root.right));

        return list;
    }

    // Recursive In-order Traversal of a Binary Tree - using Stack
    public static List<Integer> recursive2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    // Iterative In-order Traversal of a Binary Tree - using Stack
    public static List<Integer> iterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
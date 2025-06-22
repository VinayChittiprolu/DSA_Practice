import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class F1_PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Recursive1 Pre-order: " + recursive1(root));
        System.out.println("Recursive2 Pre-order: " + recursive2(root));
        System.out.println("Iterative Pre-order: " + iterative(root));
    }

    // Recursive Pre-order Traversal of a Binary Tree - Less Efficient
    public static List<Integer> recursive1(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.add(root.val);
        list.addAll(recursive1(root.left));
        list.addAll(recursive1(root.right));

        return list;
    }

    // Recursive Pre-order Traversal of a Binary Tree - Most Efficient
    public static List<Integer> recursive2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val); // Visit the root
        helper(root.left, result); // Traverse left subtree
        helper(root.right, result); // Traverse right subtree
    }

    // Iterative Pre-order Traversal of a Binary Tree - using Stack
    public static List<Integer> iterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return result;
    }
}
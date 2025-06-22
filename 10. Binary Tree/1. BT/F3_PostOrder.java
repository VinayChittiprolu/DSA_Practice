import java.util.ArrayList;
import java.util.List;

public class F3_PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Recursive Post-order: " + recursive1(root));
        System.out.println("Recursive Post-order: " + recursive2(root));
    }

    // Post-order traversal: Left -> Right -> Root
    public static List<Integer> recursive1(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.addAll(recursive1(root.left));
        list.addAll(recursive1(root.right));
        list.add(root.val);

        return list;
    }

    // Another implementation of Post-order traversal: Left -> Right -> Root
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
        helper(root.right, result);
        result.add(root.val);
    }
}
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class F10_Level_Order_II {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        List<List<Integer>> result = reverseLevelOrder(root);

        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

    public static List<List<Integer>> reverseLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                temp.add(current.val);

                // Queue left and right children (normal order)
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }

            // Add each level at the beginning to reverse the order
            result.addFirst(temp);
        }
        return result;
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class L5_Vertical_Traversal {
    static class Pair {
        TreeNode node;
        int vt;

        Pair(TreeNode node, int vt) {
            this.node = node;
            this.vt = vt; // vertical level
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        System.out.println(verticalTraversal(root));
    }

    public static ArrayList<Integer> verticalTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        HashMap<Integer, ArrayList<Integer>> verticalOrder = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (queue.size() > 0) {
            Pair front = queue.remove();
            TreeNode current = front.node;
            int vt = front.vt;

            min = Math.min(min, vt);
            max = Math.max(max, vt);

            if (verticalOrder.containsKey(vt) == false) {
                verticalOrder.put(vt, new ArrayList<>());
            }

            // Add the current node's value to the vertical order map
            verticalOrder.get(vt).add(current.val);

            if (current.left != null) {
                queue.add(new Pair(current.left, vt - 1));
            }
            if (current.right != null) {
                queue.add(new Pair(current.right, vt + 1));
            }
        }

        for (int i = min; i <= max; i++) {
            result.addAll(verticalOrder.get(i));
        }
        return result;
    }
}
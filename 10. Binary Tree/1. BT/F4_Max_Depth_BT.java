import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class F4_Max_Depth_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("DFS with recursion: " + DFS1(root));
        System.out.println("BFS with iteration: " + maxDepthBFS(root));
        System.out.println("DFS with Stack: " + DFS2(root));
    }

    // Recursive-DFS approach to find the maximum depth of a binary tree
    public static int DFS1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = DFS1(root.left);
        int right = DFS1(root.right);

        return Math.max(left, right) + 1;
    }

    // Iterative-BFS approach to find the maximum height of a binary tree using
    // level order traversal
    public static int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Using a queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        // Level order traversal
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            depth++; // one level completed
        }

        return depth;
    }

    // Iterative-DFS approach to find the maximum depth of a binary tree using a
    // stack
    public static int DFS2(TreeNode root) {
        if (root == null)
            return 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));

        int maxDepth = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int depth = current.getValue();

            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);
                if (node.left != null)
                    stack.push(new Pair<>(node.left, depth + 1));
                if (node.right != null)
                    stack.push(new Pair<>(node.right, depth + 1));
            }
        }

        return maxDepth;
    }

}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
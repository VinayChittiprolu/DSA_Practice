import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L4b_Print_Root_to_Node {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int x = 5;

        // Print the path if found, otherwise print "Target not found"
        List<Integer> path = rootToNodePathIterative(root, x);
        if (!path.isEmpty()) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " -> ");
            }
        } else {
            System.out.print("No Path Exists");
        }
    }

    // iterative solution
    public static List<Integer> rootToNodePathIterative(TreeNode root, int x) {
        if (root == null)
            return new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, new ArrayList<>()));

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode node = current.node;
            List<Integer> currentPath = current.path;

            // Add current node to the path
            currentPath.add(node.val);

            // Check if this is the target node
            if (node.val == x) {
                return currentPath;
            }

            // Push right and left children with cloned paths
            if (node.right != null) {
                stack.push(new Pair(node.right, new ArrayList<>(currentPath)));
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, new ArrayList<>(currentPath)));
            }
        }

        // If no path found
        return new ArrayList<>();
    }

    // Helper class to keep track of node and current path
    static class Pair {
        TreeNode node;
        List<Integer> path;

        Pair(TreeNode node, List<Integer> path) {
            this.node = node;
            this.path = path;
        }
    }
}
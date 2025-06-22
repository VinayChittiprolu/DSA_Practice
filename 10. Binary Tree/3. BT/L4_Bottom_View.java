import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class L4_Bottom_View {
    static class Pair {
        TreeNode node;
        int hd; // horizontal distance

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
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

        System.out.println("Bottom View: " + bottomView(root));
    }

    public static ArrayList<Integer> bottomView(TreeNode root) {
        // Initialize ArrayList for storing, collecting & returning the node values
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // HashMap to store the first node at each horizontal distance (vrtLevel)
        HashMap<Integer, Integer> bottomView = new HashMap<>();
        // Initialize the queue for level order traversal and the result list
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0)); // Start with the root node at horizontal distance 0

        // Variables to keep track of the minimum and maximum horizontal distances
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Perform level order traversal
        while (!queue.isEmpty()) {
            Pair front = queue.remove(); // Remove the front node from the queue
            TreeNode current = front.node; // Current node being processed
            int hd = front.hd; // Horizontal distance of the current node

            // Update min and max horizontal distances
            min = Math.min(min, hd);
            max = Math.max(max, hd);

            // If this is the first node at this horizontal distance, add it to the map
            bottomView.put(hd, current.val);

            // Add the left child with horizontal distance -1
            if (current.left != null) {
                queue.add(new Pair(current.left, hd - 1));
            }
            // Add the right child with horizontal distance +1
            if (current.right != null) {
                queue.add(new Pair(current.right, hd + 1));
            }
        }

        // Collect the top view nodes from the map, from min to max horizontal distances
        for (int i = min; i <= max; i++) {
            result.add(bottomView.get(i));
        }
        return result;
    }
}
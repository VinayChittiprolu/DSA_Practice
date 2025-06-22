import java.util.LinkedList;
import java.util.Queue;

public class L3_Populating_Pointer {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);
        System.out.println("Level-order traversal with next pointers:");
        printLevelOrder(root);
    }

    // Helper function to print level-order traversal with next pointers
    public static void printLevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.remove();
                System.out.print(current.val + " -> " + (current.next != null ? " " : "NULL"));

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            System.out.println(); // Print newline after each level
        }
    }

    public static Node connect(Node root) {
        // Check for empty tree
        if (root == null) {
            return null;
        }

        // Keep reference to original root to return later
        Node levelStart = root;

        // Start with the leftmost node of the current level
        while (levelStart.left != null) {
            Node current = levelStart; // Temporary variable for level traversal

            // Traverse nodes within the current level
            while (current != null) {
                // Connect left child to right child
                current.left.next = current.right;

                // Connect right child to next node's left child, if exists
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                // Move to the next node on the same level
                current = current.next;
            }

            // Move down to next level (leftmost node)
            levelStart = levelStart.left;
        }

        return root;
    }

    public static class Node {
        int val;
        Node left;
        Node right;
        Node next; // Additional pointer for level connections

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
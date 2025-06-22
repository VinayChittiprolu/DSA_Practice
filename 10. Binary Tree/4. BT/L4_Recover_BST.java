import java.util.LinkedList;
import java.util.Queue;

public class L4_Recover_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.println("Tree before recovery");
        PrintLevelOrder(root);

        recoverTree(root);
        System.out.println("Tree after recovery");
        PrintLevelOrder(root);
    }

    // Helper method to print the tree (Level-order Traversal)
    public static void PrintLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        if (root == null) {
            return;
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                System.out.print(node.val + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }

    // Static variables to keep track of the nodes to be swapped and the previous node in the in-order traversal
    static TreeNode first; // First node that is out of order
    static TreeNode second; // Second node that is out of order
    static TreeNode prev; // Previous node in the in-order traversal

    // Method to recover the BST by swapping the values of the two nodes that are out of order
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
    public static void recoverTree(TreeNode root) {
        // reset the static variables to null before starting the traversal
        first = second = prev = null;

        inOrder(root); // Perform in-order traversal to find the swapped nodes

        // Swap the values of the two nodes to fix the BST
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // Helper method to perform in-order traversal
    private static void inOrder(TreeNode root) {
        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }

        inOrder(root.left); // Recursively traverse the left subtree

        // Check for anomalies in the BST property
        if (prev != null && root.val < prev.val) {
            // If first is null, this is the first anomaly
            if (first == null) {
                first = prev; // Set the first node to be swapped
                second = root; // Set the second node to be swapped
            } else {
                // If first is already set, this is the second anomaly
                second = root; // Set the second node to be swapped
            }
        }

        prev = root;// Update prev to the current node before traversing the right subtree
        inOrder(root.right); // Recursively traverse the right subtree
    }

    // Alternative iterative solution using Morris Traversal
    // Space Complexity: O(1)
    public void recoverTreeMorris(TreeNode root) {
        TreeNode first = null, second = null, prev = null;
        TreeNode current = root;
        
        while (current != null) {
            if (current.left == null) {
                // Process current node
                if (prev != null && prev.val > current.val) {
                    if (first == null) {
                        first = prev;
                        second = current;
                    } else {
                        second = current;
                    }
                }
                prev = current;
                current = current.right;
            } else {
                // Find in-order predecessor
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) {
                    // Make current the right child of its in-order predecessor
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Revert the changes
                    predecessor.right = null;
                    
                    // Process current node
                    if (prev != null && prev.val > current.val) {
                        if (first == null) {
                            first = prev;
                            second = current;
                        } else {
                            second = current;
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        
        // Swap values
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
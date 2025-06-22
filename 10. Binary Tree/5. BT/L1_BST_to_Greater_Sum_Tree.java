import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L1_BST_to_Greater_Sum_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);

        printLevelOrder(bstToGst(root));
    }

    public static void printLevelOrder(TreeNode root) {
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

    // 1. Recursive approach to convert BST to Greater Sum Tree
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(h) where h is the height of the tree (due to recursion
    // stack)
    // Accumulator to store the sum of all greater or equal node values
    static int greater = 0;

    public static TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        return root;
    }

    // Helper method to perform reverse in-order traversal
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse right subtree first (greater values)
        inOrder(root.right);

        // Update cumulative sum and the current node's value
        greater = greater + root.val;
        root.val = greater;

        // Traverse left subtree (smaller values)
        inOrder(root.left);
    }

    // 2. Iterative approach to convert BST to Greater Sum Tree
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(n) for the stack used in the traversal
    public class BSTToGreaterSumTreeIterative {
        public static TreeNode bstToGst(TreeNode root) {
            int cumulativeSum = 0;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode current = root;

            while (!stack.isEmpty() || current != null) {
                // Go as right as possible
                while (current != null) {
                    stack.push(current);
                    current = current.right;
                }

                current = stack.pop();
                cumulativeSum += current.val;
                current.val = cumulativeSum;

                // Move to left subtree
                current = current.left;
            }
            return root;
        }
    }

    // 3. Morris Traversal approach to convert BST to Greater Sum Tree
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(1) as it does not use any extra space for stack or
    // recursion
    public class BSTToGreaterSumTreeMorris {
        public static TreeNode bstToGstMorris(TreeNode root) {
            int cumulativeSum = 0;
            TreeNode current = root;

            while (current != null) {
                if (current.right == null) {
                    cumulativeSum += current.val;
                    current.val = cumulativeSum;
                    current = current.left;
                } else {
                    // Find the in-order predecessor
                    TreeNode predecessor = current.right;
                    while (predecessor.left != null && predecessor.left != current) {
                        predecessor = predecessor.left;
                    }

                    // Make current as the left child of its in-order predecessor
                    if (predecessor.left == null) {
                        predecessor.left = current;
                        current = current.right;
                    } else {
                        // Revert the changes made to restore the original tree structure
                        predecessor.left = null;
                        cumulativeSum += current.val;
                        current.val = cumulativeSum;
                        current = current.left;
                    }
                }
            }
            return root;
        }
    }
}
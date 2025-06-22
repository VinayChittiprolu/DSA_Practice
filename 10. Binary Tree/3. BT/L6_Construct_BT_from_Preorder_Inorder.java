import java.util.HashMap;

public class L6_Construct_BT_from_Preorder_Inorder {
    public static void main(String[] args) {
        int[] preOrder = { 3, 9, 20, 15, 7 };
        int[] inOrder = { 9, 3, 15, 20, 7 };
        System.out.println(buildTree(preOrder, inOrder));
    }

    // HashMap to store inOrder element's index for efficient lookup during tree
    // construction
    public static HashMap<Integer, Integer> map;

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        int n = inOrder.length;
        map = new HashMap<>();

        // Build a map to store the index of each element in the inOrder traversal
        for (int i = 0; i < n; i++) {
            map.put(inOrder[i], i);
        }
        // Call the helper function to construct the tree recursively
        return construct(preOrder, 0, n - 1, inOrder, 0, n - 1);
    }

    public static TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        // Base case: Empty subtree in pre-order or in-order traversal
        if (ps > pe || is > ie) {
            return null;
        }
        // Create a new node with the value from the current pre-order position
        TreeNode root = new TreeNode(pre[ps]);
        // Find the index of the root value in the in-order traversal using the
        // pre-built
        // map
        int idx = map.get(pre[ps]);
        // Calculate the number of elements in the left subtree based on in-order index
        // positions
        int count = idx - is;
        // Recursively build the left and right+ subtree from pre-order and in-order
        // traversals
        root.left = construct(pre, ps + 1, ps + count, in, is, idx - 1);
        root.right = construct(pre, ps + count + 1, pe, in, idx + 1, ie);

        return root;
    }
}
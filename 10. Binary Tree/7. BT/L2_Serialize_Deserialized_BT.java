import java.util.LinkedList;
import java.util.Queue;

public class L2_Serialize_Deserialized_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serializedData = serialize(root); // Serialize the tree

        levelOrder(deserialize(serializedData)); // Print the deserialize tree in level order
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        if (root == null) {
            return;
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.remove();

                if (node != null) {
                    System.out.print(node.val + " ");
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder(); // Serializes a binary tree to a string.
        Helper1(root, sb); // Call helper function to perform serialization
        return sb.toString();
    }

    // Helper function to serialize a subtree into a StringBuilder
    public static void Helper1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# "); // Append marker for empty tree branch
            return;
        }

        sb.append(root.val + " "); // Append node value and space
        Helper1(root.left, sb); // Recursively serialize left subtree
        Helper1(root.right, sb); // Recursively serialize right subtree
    }

    // Decodes your encoded data to tree.
    public static int i;

    public static TreeNode deserialize(String data) {
        String[] ch = data.split(" ");
        i = 0;
        return Helper2(ch);
    }

    // Helper function to deserialize a tree structure from a String array
    public static TreeNode Helper2(String[] ch) {
        if (ch[i].equals("#")) {
            i++;
            return null;
        }

        // Create new TreeNode from current element (parsed as integer)
        TreeNode root = new TreeNode(Integer.parseInt(ch[i]));
        i++;
        root.left = Helper2(ch); // Recursively deserialize left subtree
        root.right = Helper2(ch); // Recursively deserialize right subtree
        return root;
    }
}
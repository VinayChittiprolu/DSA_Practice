import java.util.ArrayList;

public class L4a_Print_Root_To_Node {
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
        if (RootToNode(root, x)) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " -> ");
            }
        } else {
            System.out.print("No Path Exists");
        }
    }

    // Global variable to store the path from root to the node
    private static ArrayList<Integer> path = new ArrayList<>();

    // recursive solution
    public static boolean RootToNode(TreeNode root, int x) {
        // if root is NULL there is no path
        if (root == null) {
            return false;
        }

        // push the node's value in 'path'
        path.add(root.val);

        // if it is the required node return true
        if (root.val == x) {
            return true;
        }

        // else check whether the required node lies in the left subtree or right
        // subtree of the current node
        if (RootToNode(root.left, x) || RootToNode(root.right, x)) {
            return true;
        }

        // required node does not lie either in the left or right subtree of the current
        // node Thus, remove current node's value from 'path' and then return false
        path.remove(path.size() - 1);
        return false;
    }
}
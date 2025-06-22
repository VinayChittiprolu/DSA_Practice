import java.util.ArrayList;

public class L4_Longest_Path_Root_to_Leaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        printLongestPath(root);
    }

    public static ArrayList<Integer> longestPath(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> leftPath = longestPath(root.left);
        ArrayList<Integer> rightPath = longestPath(root.right);

        // Choose the longer path and add current root to it
        if (leftPath.size() > rightPath.size()) {
            leftPath.add(0, root.val);
            return leftPath;
        } else {
            rightPath.add(0, root.val);
            return rightPath;
        }
    }

    public static void printLongestPath(TreeNode root) {
        ArrayList<Integer> path = longestPath(root);
        int n = path.size();

        System.out.print(path.get(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            System.out.print(" -> " + path.get(i));
        }
    }
}
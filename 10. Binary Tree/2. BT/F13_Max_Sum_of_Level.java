import java.util.LinkedList;
import java.util.Queue;

public class F13_Max_Sum_of_Level {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(80);
        root.left.left.right = new TreeNode(-65);

        maxLevelSum(root);
    }

public static int maxLevelSum(TreeNode root) {
    int maxSum = root.val;
    int level = 0;
    int ans = 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        int size = queue.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {
            TreeNode current = queue.remove();
            sum += current.val;

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        if (sum > maxSum) {
            maxSum = sum;
            ans = level;
        }

        level++;
    }
    
    System.out.println("Max sum is: " + maxSum + ", at level: " + ans);
    return ans;
}
}

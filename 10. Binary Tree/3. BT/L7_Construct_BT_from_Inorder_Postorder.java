import java.util.HashMap;

public class L7_Construct_BT_from_Inorder_Postorder {
    public static void main(String[] args) {

    }

    public static HashMap<Integer, Integer> map;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return construct(postorder, 0, n - 1, inorder, 0, n - 1);
    }

    public static TreeNode construct(int[] post, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(post[pe]);
        int idx = map.get(post[pe]);

        int count = idx - is;

        root.left = construct(post, ps, ps + count - 1, in, is, idx - 1);
        root.right = construct(post, ps + count, pe - 1, in, idx + 1, ie);

        return root;
    }
}
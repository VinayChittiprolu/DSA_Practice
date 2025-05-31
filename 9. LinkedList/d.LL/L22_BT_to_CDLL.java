public class L22_BT_to_CDLL {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);

        root = bTreeToClist(root);
        printList(root);
    }

    public static void printList(Node node) {
        Node start = node;
        boolean firstPass = true;
        while (firstPass || node != start) {
            firstPass = false;
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    public static Node CDLL(Node H1, Node H2) {
        Node T1 = H1.left;
        Node T2 = H2.left;

        T1.right = H2;
        H2.left = T1;

        T2.right = H1;
        H1.left = T2;

        return H1;
    }

    public static Node bTreeToClist(Node root) {

        if (root == null) {
            return null;
        }

        Node temp_left = bTreeToClist(root.left);
        Node temp_right = bTreeToClist(root.right);

        if (temp_left == null && temp_right == null) {
            root.left = root;
            root.right = root;
            return root;
        }

        else if (temp_left == null && temp_right != null) {
            root.left = root;
            root.right = root;
            CDLL(root, temp_right);
            return root;
        }

        else if (temp_left != null && temp_right == null) {
            root.left = root;
            root.right = root;
            CDLL(temp_left, root);
            return temp_left;
        }

        else {
            root.left = root;
            root.right = root;
            CDLL(temp_left, root);
            CDLL(temp_left, temp_right);
            return temp_left;
        }
    }

    public static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
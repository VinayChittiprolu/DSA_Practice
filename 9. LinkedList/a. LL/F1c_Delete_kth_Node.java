public class F1c_Delete_kth_Node {
    public static class Node {
        int val; // Value of the node stored in the node
        Node next; // Pointer to the next node in the linked list

        // Constructor to initialize the node with a value and set next to null
        public Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(1);
        head.next.next.next = new Node(9);

        Node del = head.next; // 4 -> 5 -> 1 -> 9 ->
        printList(head);
        deleteNode(del);
        printList(head); // Expected: 4 -> 1 -> 9 -> null
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
        
    }

    public static void deleteNode(Node node) {
        // Check if node or its next is null
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val; // Copy the value of the next node
        node.next = node.next.next; // Bypass the next node
    }
}
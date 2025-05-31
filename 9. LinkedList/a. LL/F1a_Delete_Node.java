public class F1a_Delete_Node {
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
        // Sample linked list creation
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        int x = 2;

        Node newHead = deleteNode(head, x);

        // Print the modified linked list (optional)
        while (newHead != null) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
        System.out.println("NULL");
    }

    public static Node deleteNode(Node head, int x) {
        // Empty list
        if (head == null || x < 1) {
            return null;
        }

        // If x is 1, we need to delete the head node
        if (x == 1) {
            return head.next;
        }

        // Initialize pointers
        Node current = head; // Start from the head

        // Traverse the list to find the node to delete
        for (int i = 1; i < x - 1 && current != null; i++) {
            current = current.next;
        }

        // Check if the position is valid (avoid out-of-bounds)
        if (current == null || current.next == null) {
            return head;
        }

        current.next = current.next.next; // Bypass the node to delete it

        return head;
    }
}
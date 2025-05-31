public class F1b_Delete_Node {
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
        Node dummy = new Node(0); // Create a dummy node to handle edge cases
        dummy.next = head; // Link the dummy node to the head
        Node current = dummy; // Start from the dummy node

        // Traverse the list to find the node to delete
        for (int i = 1; i < x && current.next != null; i++) {
            current = current.next;
        }

        // Check if the position is valid (avoid out-of-bounds)
        if (current.next != null) {
            current.next = current.next.next;
        }

        // Return the modified list starting from the node after the dummy
        return dummy.next;
    }
}
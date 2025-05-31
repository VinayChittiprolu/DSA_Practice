public class F6_Remove_Duplicates_II {
    public static class Node {
        int val; // Value of the node stored in the node
        Node next; // Pointer to the next node in the linked list

        // Constructor to initialize the node with a value and set next to null
        public Node(int x) {
            val = x;
            next = null;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating the list: 1 → 2 → 3 → 3 → 4 → 4 → 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(5);

        System.out.print("Original list: ");
        printList(head);

        Node result = removeDuplicates(head);

        System.out.print("After removing all duplicates: ");
        printList(result);
    }

    // Helper method to print the list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node removeDuplicates(Node head) {
        Node dummy = new Node(0); // dummy node before head
        dummy.next = head; // points to the head of the list

        Node tail = dummy; // points to the last node before duplicates
        Node current = head; // points to the current node

        while (current != null) {
            // Check if current node has duplicates
            if (current.next != null && current.val == current.next.val) {
                // Skip all duplicates
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Skip the last duplicate too
                tail.next = current.next;
            } else {
                tail = tail.next; // Move tail to the next node
            }
            current = current.next; 
        }

        return dummy.next; 
    }
}
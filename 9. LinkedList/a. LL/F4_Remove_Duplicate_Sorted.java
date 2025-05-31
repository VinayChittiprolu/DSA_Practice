public class F4_Remove_Duplicate_Sorted {
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
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        deleteDuplicates(head);

        Node newHead = head;
        while (newHead != null) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
        System.out.println();
    }

    public static Node deleteDuplicates(Node head) {
        if (head == null) {
            return null;
        }

        // Initialize a reference pointer to the same node in memory to traverse the list.
        Node current = head;

        while (current.next != null) { // Iterate until the next node is null (end of list).
            // Check if the current node has the same value as the next node.
            if (current.val == current.next.val) {
                // If duplicate found, bypass the next node by updating the next pointer.
                current.next = current.next.next;
            } else {
                // If no duplicate found, move to the next node.
                current = current.next;
            }
        }
        return head; // Return the head of the updated list
    }
}
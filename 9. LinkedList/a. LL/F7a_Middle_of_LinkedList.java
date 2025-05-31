public class F7a_Middle_of_LinkedList {
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
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node new_head = middleNode(head);

        while (new_head != null) {
            System.out.print(new_head.val + " -> ");
            new_head = new_head.next;
        }

        System.out.println();
    }

    public static Node middleNode(Node head) {
        int count = 0; // Counter to keep track of the number of nodes
        Node current = head; // Pointer to traverse the list

        // Traverse the list to count the number of nodes
        while (current != null) {
            count++;
            current = current.next;
        }

        int mid = count / 2; // Calculate the middle index
        current = head; // Reset the pointer to the head of the list

        // Traverse the list again to reach the middle node
        for (int i = 0; i < mid; i++) {
            current = current.next;
        }
        
        return current;
    }
}
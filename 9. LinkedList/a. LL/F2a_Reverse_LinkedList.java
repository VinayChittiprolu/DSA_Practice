public class F2a_Reverse_LinkedList {
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

        Node newHead = reverseListRecursive(head);

        while (newHead != null) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
        System.out.println();
    }

    public static Node reverseListRecursive(Node head) {
        // Base case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head; // Return the head
        }

        // Recursive case: reverse the rest of the list
        Node newHead = reverseListRecursive(head.next);
        head.next.next = head; // Set the next node's next to the current node
        head.next = null; // Set the current node's next to null

        return newHead; // Return the new head of the reversed list
    }
}
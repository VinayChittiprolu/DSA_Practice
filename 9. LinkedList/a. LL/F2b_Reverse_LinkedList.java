public class F2b_Reverse_LinkedList {
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

        Node newHead = reverseList(head);

        while (newHead != null) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
        System.out.println();
    }

    // Reverse the entire linked list
    public static Node reverseList(Node head) {
        // Base case: if the list is empty or has only one node, return it as is
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize two pointers: 'prev' to null and 'current' to head of the list
        Node current = head;
        Node prev = null;

         // Loop through the list until we reach the end
        while (current != null) {
            Node temp = current.next; // Temporarily store the next node
            current.next = prev; // Reverse the current node's pointer
            
            // Move 'prev' and 'current' one step forward
            prev = current;
            current = temp;
        }
        return prev;
    }
}
public class F3_Reverse_LinkedList_II {
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

        int m = 2, n = 4; // Reverse from value 2 to value 4

        head = reverseBetween(head, m, n);

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Reverse the list from node with value m to node with value n
    public static Node reverseBetween(Node head, int left, int right) {
        // Edge case: if the list is empty or no reversal is needed
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify edge cases where left == 1
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        // Move 'prev' to the node just before the 'left' position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 'current' will point to the node at position 'left'
        Node current = prev.next;
        Node nextNode = null;

        // Reverse the sub-list from 'left' to 'right'
        for (int i = 0; i < right - left; i++) {
            nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        // Return the head of the new list
        return dummy.next;
    }
}
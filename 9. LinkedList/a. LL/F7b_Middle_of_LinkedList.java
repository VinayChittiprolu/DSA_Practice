public class F7b_Middle_of_LinkedList {
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
        Node slow = head; // Slow pointer to find the middle node
        Node fast = head; // Fast pointer to traverse the list at double speed

        // Traverse the list with slow moving one step and fast moving two steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
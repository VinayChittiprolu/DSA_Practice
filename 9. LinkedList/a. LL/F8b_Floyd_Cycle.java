public class F8b_Floyd_Cycle {
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

        // Creating a cycle: 5 -> 3
        head.next.next.next.next.next = head.next;

        if (hasCycle(head)) {
            System.out.println("Cycle detected.");
        } else {
            System.out.println("No cycle detected.");
        }
    }

    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move one step
            fast = fast.next.next; // Move two steps

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }
}
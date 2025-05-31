public class F9b_Floyd_Cycle_II {
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
        // Creating nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a cycle: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        Node cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle detected at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }

    public static Node detectCycle(Node head) {
        Node slow = head; // Slow pointer to find the meeting point
        Node fast = head; // Fast pointer to traverse the list at double speed

        //First phase: Detect if there is a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast pointers meet, there is a cycle
            if (slow == fast) {
                break;
            }
        }

        // If fast pointer reaches the end, there is no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Second phase: Find the start of the cycle
        fast = head; // Reset fast pointer to the head
        // Move both pointers one step at a time until they meet again 
        while (fast != slow) {
            // the meeting point will be the start of the cycle
            fast = fast.next; 
            slow = slow.next; 
        }

        // Return the node where the cycle starts
        return slow;
    }
}
import java.util.HashSet;
import java.util.Set;

public class F8a_Floyd_Cycle {
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
        head.next.next.next.next.next = head.next.next; // Cycle at node with value 3

        Node cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle detected at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }

    public static Node detectCycle(Node head) {
        Set<Node> visited = new HashSet<>();

        Node current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return current; // Start of the cycle
            }

            visited.add(current); // Mark the current node as visited
            current = current.next; //
        }

        return null; // No cycle
    }
}
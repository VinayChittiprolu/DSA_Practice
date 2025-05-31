import java.util.HashSet;
import java.util.Set;

public class F9a_Floyd_Cycle_II {
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
        Set<Node> visited = new HashSet<>(); // Set to keep track of visited nodes
        Node current = head; // Start from the head of the list
       
        // Traverse the list and check for cycles
        while (current != null) {
            // If the current node is already visited, we found a cycle
            if (visited.contains(current)) {
                return current; // Start of the cycle
            }

            visited.add(current);  // Add the current node to the visited set
            current = current.next;  // Move to the next node
        }

        return null; // No cycle
    }
}
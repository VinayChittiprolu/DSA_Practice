import java.util.ArrayList;
import java.util.List;

public class F10a_Change_Order {
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

        reorderList(head);
        Node new_head = head;

        while (new_head != null) {
            System.out.print(new_head.val + " -> ");
            new_head = new_head.next;
        }

        System.out.println();
    }

    public static void reorderList(Node head) {
        // Base case: if the list is empty or has only one node, no reordering needed
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Store all nodes in a list
        List<Node> node = new ArrayList<>();
        Node current = head;
        // Traverse the linked list and add each node to the list
        while (current != null) {
            node.add(current);
            current = current.next;
        }

        // Step 2: Reorder nodes using two pointers
        int left = 0; // Start from the beginning of the list
        int right = node.size() - 1; // Start from the end of the list
        // Split the list into two halves and reverse the second half
        while (left < right) {
            node.get(left).next = node.get(right); // Link the left node to the right node
            left++;
            if (left == right) {
                break; // In case of odd number of nodes
            }
            node.get(right).next = node.get(left); // Link the right node to the next left node
            right--;
        }

        // Step 3: Terminate the list
        node.get(left).next = null;
    }
}
public class F10b_Change_Order {
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

    public static Node reorderList(Node head) {
        // Base case: if the list is empty or has only one node, no reordering needed
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the middle of the list using the slow and fast pointers
        Node slow = head; 
        Node fast = head; 
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }

        // Step 2: Reverse the second half of the list
        Node current = slow.next; // Start from the node after the middle
        Node tail = null;  // Tail will point to the head of the reversed second half
        slow.next = null; // Split the list into two halves
        // Reverse the second half of the list
        while (current != null) {  
            Node temp = current.next; 
            current.next = tail; 
            tail = current; 
            current = temp; 
        }

        // Step 3: Merge the two halves of the list
        Node left = head; // Start from the head of the first half
        Node right = tail; // Start from the head of the reversed second half
        // Merging the two halves by alternating nodes from each half
        while (right != null) {
            Node tempLeft = left.next; 
            Node tempRight = right.next; 

            left.next = right;
            right.next = tempLeft; 

            left = tempLeft; 
            right = tempRight; 
        }

        return head; // Returning the reordered list
    }
}
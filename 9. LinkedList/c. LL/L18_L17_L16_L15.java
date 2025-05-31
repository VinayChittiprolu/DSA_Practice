public class L18_L17_L16_L15 {
    // Definition for a Node in the doubly linked list
    public static class Node {
        int val;
        Node next;
        Node prev;

        // Constructor to create a new node with a given value
        Node(int x) {
            val = x;
            next = null;
            prev = null;
        }
    }

    public static void main(String[] args) {
        Node head = null; // Example usage can be added here

        // Insert at head
        head = insertHead(head, 10); // List: 10
        head = insertHead(head, 5); // List: 5 10
        System.out.print("Initial List: ");
        printList(head);

        // Insert at end
        insertTail(head, 20); // List: 5 10 20
        insertTail(head, 30); // tail = 20; Insert 30 after tail
        System.out.print("After inserting at tail: ");
        printList(head);

        // Insert after 10
        insertAfter(head.next, 15); // List: 5 10 15 20 30
        System.out.print("After inserting after 10: ");
        printList(head);

        // Insert before 10
        insertBefore(head.next, 7); // List: 5 7 10 15 20 30
        System.out.print("After inserting before 10: ");
        printList(head);
    }

    // Function to print the list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" <--> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static Node insertHead(Node head, int x) {
        Node newNode = new Node(x);
        newNode.prev = null;
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        return newNode; // New head of the list
    }

    public static Node insertTail(Node head, int x) {
        Node newNode = new Node(x);
        newNode.next = null;

        if (head == null) {
            newNode.prev = null;
            return newNode; // New head of the list
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;

        return head; // Head remains unchanged
    }

    public static Node insertAfter(Node targetNode, int x) {
        if (targetNode == null) {
            return null;
        }

        Node newNode = new Node(x);
        newNode.next = targetNode.next;
        newNode.prev = targetNode;

        if (targetNode.next != null) {
            targetNode.next.prev = newNode;
        }

        targetNode.next = newNode;

        return newNode; // New node inserted after targetNode
    }

    public static Node insertBefore(Node targetNode, int x) {
        if (targetNode == null) {
            return null;
        }

        Node newNode = new Node(x);
        newNode.next = targetNode;
        newNode.prev = targetNode.prev;

        if (targetNode.prev != null) {
            targetNode.prev.next = newNode;
        }

        targetNode.prev = newNode;

        return newNode; // New node inserted before targetNode
    }
}
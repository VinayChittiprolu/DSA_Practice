public class L17_Insert_After_Node_DLL {
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
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        int x = 4;
        System.out.print("Given List: ");
        printList(head);

        System.out.print("Inserting " + x + " after the second node: ");
        insertAfter(second, x);
        printList(head);
    }

    // Function to print the list
    static void printList(Node head) {
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

    static Node insertAfter(Node targetNode, int x) {
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

        return newNode; // Return the new node
    }
}
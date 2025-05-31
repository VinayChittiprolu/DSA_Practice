public class L16_Insert_Tail_DLL {
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
        Node second = new Node(3);
        Node third = new Node(4);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        int x = 6;

        System.out.print("Given List: ");
        printList(head);

        System.out.print("Inserting " + x + " at the end: ");
        head = insertTail(head, x);
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

    static Node insertTail(Node head, int x) {
        Node newNode = new Node(x);
        newNode.next = null;

        if (head == null) {
            newNode.prev = null;
            return newNode;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        newNode.prev = last;
        last.next = newNode;

        return head;
    }
}
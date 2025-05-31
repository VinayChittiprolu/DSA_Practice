public class L14_Delete_Node_DLL {
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
        // Creating the doubly linked list: 1 <--> 3 <--> 4
        Node head1 = new Node(1);
        Node second = new Node(3);
        Node third = new Node(4);
        head1.next = second;
        second.prev = head1;
        second.next = third;
        third.prev = second;

        // Creating the doubly linked list: 1 <--> 5 <--> 2 <--> 9
        Node head2 = new Node(1);
        Node second1 = new Node(5);
        Node third1 = new Node(2);
        Node fourth1 = new Node(9);
        head2.next = second1;
        second1.prev = head2;
        second1.next = third1;
        third1.prev = second1;
        third1.next = fourth1;
        fourth1.prev = third1;

        int position1 = 3; // Position to delete in the first list
        int position2 = 1; // Position to delete in the second list

        head1 = deleteNode(head1, position1); // Delete the node at position 3 (which is '4')
        head2 = deleteNode(head2, position2); // Delete the node at position 1 (which is '1')

        // Print the modified list
        System.out.print("Modified List: ");
        printList(head1);
        System.out.print("Modified List: ");
        printList(head2);
    }

    // Helper Function to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" <--> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node deleteNode(Node head, int position) {
        // If the list is empty or position is invalid
        if (head == null || position <= 0) {
            return head; // Return the head as is
        }

        // Pointer to traverse the list
        Node current = head;

        // Traverse the list to the node at the given position
        while (position > 1) {
            current = current.next;
            position--;
        }

        // Pointers to the previous and next nodes of the current node
        Node previousNode = current.prev;
        Node nextNode = current.next;

        // Case 1: If the node to delete is the head node
        if (previousNode == null) {
            head = head.next;
            head.prev = null;
            return head;
        }
        // Case 2: If the node to delete is the last node
        else if (nextNode == null) {
            previousNode.next = null;
            current.prev = null;
        }
        // Case 3: If the node to delete is a middle node
        else {
            previousNode.next = nextNode;
            nextNode.prev = previousNode;
            current.next = null; // Clean up the deleted node's next pointer
            current.prev = null; // Clean up the deleted node's prev pointer
        }

        return head;
    }
}
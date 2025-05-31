import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L11a_Merge_Sorted_LL {
    static class Node {
        int val;
        Node next;

        public Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        int[] N = { 5, 10, 15, 40 };
        int[] M = { 2, 3, 20 };

        // Simpler loop for creating linked lists
        Node head1 = createLinkedList(N);
        Node head2 = createLinkedList(M);

        // Call your merge function here
        Node mergedHead = mergeSortedLinkedLists(head1, head2);

        // Printing the final linked list
        printList(mergedHead);
    }

    // Helper function to create a linked list from an array
    static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node mergeSortedLinkedLists(Node list1, Node list2) {
        // Step 1: Collect all node values from both lists
        List<Integer> values = new ArrayList<>();

        Node current = list1; // Start with the first list
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        current = list2; // Then process the second list
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        // Step 2: Sort the collected values
        Collections.sort(values);

        // Step 3: Rebuild the sorted linked list
        Node dummyHead = new Node(0); // Temporary dummy node to simplify construction
        Node tail = dummyHead;
        for (int val : values) {
            tail.next = new Node(val);
            tail = tail.next;
        }

        return dummyHead.next; // Return the head of the merged list
    }
}
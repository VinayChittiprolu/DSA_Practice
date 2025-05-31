public class L11b_Merge_Sorted_LL {
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
        // Handle edge cases where one or both lists are empty
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Initialize pointers for the merged list
        Node head; // Head of the merged list
        Node tail; // Tail of the merged list, used for appending nodes

        // Start with the smaller value node from the two lists
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        tail = head; // Set tail to head initially, as it will be the start of the merged list

        // Iterate over both lists and merge them in sorted order
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1; // Append list1's node
                list1 = list1.next; // Move list1 to its next node
            } else {
                tail.next = list2; // Append list2's node
                list2 = list2.next; // Move list2 to its next node
            }
            tail = tail.next; // Move merged-tail to the newly added node
        }

        // Attach any remaining nodes from list1 or list2
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return head; // Return the head of the merged sorted list
    }
}
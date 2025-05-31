public class L12_MergeSort_for_LL {
    static class Node {
        int val;
        Node next;

        public Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original list:");
        printList(head);

        Node sortedHead = mergeSort(head);

        System.out.println("Sorted list:");
        printList(sortedHead);
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main merge sort function
    public static Node mergeSort(Node head) {
        // Base case: If the list has one or no elements, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle node to split the list
        Node middle = mid(head);
        Node rightHead = middle.next;
        middle.next = null; // Split the list into two halves

        // Recursively sort both halves
        Node leftSorted = mergeSort(head);
        Node rightSorted = mergeSort(rightHead);

        // Merge the sorted halves
        return mergeSortedLinkedLists(leftSorted, rightSorted);
    }

    // Function to merge two sorted linked lists
    public static Node mergeSortedLinkedLists(Node list1, Node list2) {
        // Handle base cases where one of the lists is empty
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        Node head; // Head of the merged list
        Node tail; // Tail to build the merged list

        // Initialize the merged list with the smaller head node
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        tail = head;

        // Merge the remaining nodes
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach any remaining nodes from list1 or list2
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return head;
    }

    // Function to find the middle node of the linked list
    public static Node mid(Node head) {
        Node slow = head;
        Node fast = head;

        // Use the fast and slow pointer technique to find the middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
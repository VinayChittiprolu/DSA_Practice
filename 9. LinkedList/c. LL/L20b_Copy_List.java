public class L20b_Copy_List {
    static class Node {
        int val; // Value of the node.
        Node next; // Pointer to the next node in the list.
        Node random; // Pointer to a random node in the list.

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        // Create the original list
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;

        // Set random pointers
        node1.random = node3; // 1's random points to 3
        node2.random = node1; // 2's random points to 1
        node3.random = node2; // 3's random points to 2

        System.out.println("Original list:");
        printList(node1);

        Node copiedHead = copyRandomList(node1);
        System.out.println("\nCopied list:");
        printList(copiedHead);
    }

    // Prints the values and random pointers of the nodes in the list.
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            int randomVal; // Determine the value of the random pointer, or -1 if it's null.

            if (current.random != null) {
                randomVal = current.random.val;
            } else {
                randomVal = -1;
            }

            System.out.println("Node val: " + current.val + ", Random val: " + randomVal);
            current = current.next; // Move to the next node.
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: Interleave copied nodes with original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next; // Move to the next original node
        }

        // Step 2: Set random pointers for copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Move to the next original node
        }

        // Step 3: Separate the two lists
        Node dummyHead = new Node(0); // Dummy head for copied list
        Node copyCurr = dummyHead;
        curr = head;

        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next; // Restore original list
            copyCurr.next = copy; // Build copied list
            copyCurr = copy;
            curr = curr.next; // Move to next original node
        }

        return dummyHead.next; // Head of the copied list
    }
}
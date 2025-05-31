public class L13c_Intersection_LL {
    static class Node {
        int val;
        Node next;

        public Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        // Create intersecting lists
        Node intersection = new Node(6);
        intersection.next = new Node(7);

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = intersection;

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = intersection;

        Node result = intersectPointFloyd(head1, head2);
        if (result != null) {
            System.out.println("Intersection at node with data: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }
    }

    static Node intersectPointFloyd(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        // Step 1: Connect tail of head1 to head2
        Node tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }
        tail1.next = head2; // Temporarily connect to form a cycle if there is an intersection

        // Step 2: Initialize slow and fast pointers
        Node slow = head1;
        Node fast = head1;

        // Step 3: Move slow (1 step) and fast (2 steps) until they meet or fast reaches
        // null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 4: Reset slow to head1, move both one step at a time
                slow = head1;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // Step 5: Restore original list structure and return intersection node
                tail1.next = null;
                return slow;
            }
        }

        // Step 6: No cycle found (fast reached null), so no intersection
        tail1.next = null; // Restore original list structure
        return null;
    }
}
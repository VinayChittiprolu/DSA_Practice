public class L13b_Intersection_LL {
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

        int result = intersectPoint(head1, head2);
        if (result != -1) {
            System.out.println("Intersection at node with data: " + result);
        } else {
            System.out.println("No intersection found.");
        }
    }

    public static int intersectPoint(Node head1, Node head2) {
        // If either list is empty, there can be no intersection
        if (head1 == null || head2 == null) {
            return -1;
        }

        Node pointer1 = head1, pointer2 = head2; // Initialize two pointers for both lists
        int size1 = 0, size2 = 0; // To keep track of the lengths of both lists

        // Calculate the length of the first linked list
        while (pointer1 != null) {
            size1++;
            pointer1 = pointer1.next;
        }
        // Calculate the length of the second linked list
        while (pointer2 != null) {
            size2++;
            pointer2 = pointer2.next;
        }

        // Reset pointers to heads again
        pointer1 = head1;
        pointer2 = head2;

        // Advance the pointer of the longer list by the difference in lengths
        if (size1 > size2) {
            int diff = size1 - size2;
            while (diff > 0) {
                pointer1 = pointer1.next;
                diff--;
            }
        } else {
            int diff = size2 - size1;
            while (diff > 0) {
                pointer2 = pointer2.next;
                diff--;
            }
        }

        // Traverse both lists simultaneously, checking for intersection
        while (pointer1 != null && pointer2 != null && pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        // Intersection point found, return its data value
        if (pointer1 == null || pointer2 == null) {
            return -1;
        } else {
            // If pointers meet, it means they intersect
            return pointer1.val;
        }
    }
}
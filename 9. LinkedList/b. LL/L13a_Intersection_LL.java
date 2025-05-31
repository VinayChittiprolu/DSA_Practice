public class L13a_Intersection_LL {
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

        Node result = intersectPoint(head1, head2);
        if (result != null) {
            System.out.println("Intersection at node with data: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }
    }

    public static Node intersectPoint(Node head1, Node head2) {
        // Traverse list 1
        Node current1 = head1;
        while (current1 != null) {
            // For each node in list 1, traverse list 2
            Node current2 = head2;
            while (current2 != null) {
                // Intersection found
                if (current1 == current2) {
                    return current1;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }

        return null; // No intersection found
    }
}
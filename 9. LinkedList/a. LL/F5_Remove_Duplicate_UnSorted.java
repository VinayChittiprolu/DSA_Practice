import java.util.HashSet;
public class F5_Remove_Duplicate_UnSorted {
    public static class Node {
        int val;
        Node next;

        public Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(1);

        removeDuplicates(head);

        Node newHead = head;
        while (newHead != null) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
        System.out.println();
    }

    public static Node removeDuplicates(Node head) {
        if (head == null) {
            return null; // If the list is empty, return null
        }

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.val)) {
                prev.next = current.next; // Bypass the current node
            } else {
                seen.add(current.val); // Not a duplicate, add to the set
                prev = current; // Move prev to current
            }
            current = prev.next; // Move to the next node
        }
        return head; // Return the head of the updated list
    }
}
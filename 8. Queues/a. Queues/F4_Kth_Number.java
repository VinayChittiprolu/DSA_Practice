import java.util.LinkedList;
import java.util.Queue;

public class F4_Kth_Number {
    public static void main(String[] args) {
        System.out.println(KthNumber(1));
        System.out.println(KthNumber(2));
        System.out.println(KthNumber(3));
        System.out.println(KthNumber(4));
    }

    public static String KthNumber(int k) {
        // Initialize a queue to hold strings composed of '1' and '2'
        Queue<String> q = new LinkedList<>();
        String ans = ""; // This will eventually hold the k-th string

        // Start with "1" and "2" as the first two elements in the sequence
        q.add("1");
        q.add("2");

        // Run the loop k times to reach the k-th number in the sequence
        for (int i = 0; i < k; i++) {
            String temp = q.remove(); // Remove the head of the queue
            ans = temp; // Store the current string as the latest result

            // Generate the next two strings in the sequence
            q.add(temp + "1");
            q.add(temp + "2");
        }
        return ans;
    }
}
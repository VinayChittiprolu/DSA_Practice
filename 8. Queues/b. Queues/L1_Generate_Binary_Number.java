import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L1_Generate_Binary_Number {
    public static void main(String[] args) {
        System.out.println(Generate(1));
        System.out.println(Generate(2));
        System.out.println(Generate(3));
        System.out.println(Generate(4));
    }

    public static ArrayList<String> Generate(int n) {
        // Initialize a queue to hold strings composed of '0' and '1'
        Queue<String> q = new LinkedList<>();
        ArrayList<String> num = new ArrayList<>(); // holds the binary numbers

        q.add("1"); // Start with the initial binary number "1"

        // Generate binary numbers until 'n' count is reached
        for (int i = 0; i < n; i++) {
            String temp = q.remove(); // Remove the head of the queue
            num.add(temp); // Add the current binary number to the list

            // Generate the next binary numbers by appending "0" and "1" to the current
            // number
            q.add(temp + "0");
            q.add(temp + "1");
        }
        return num;
    }
}
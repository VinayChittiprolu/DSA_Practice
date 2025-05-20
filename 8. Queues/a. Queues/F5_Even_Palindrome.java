import java.util.LinkedList;
import java.util.Queue;

public class F5_Even_Palindrome {
    public static void main(String[] args) {
        System.out.println(KthPalindrome(1));
        System.out.println(KthPalindrome(2));
        System.out.println(KthPalindrome(3));
        System.out.println(KthPalindrome(4));
    }

    public static String KthPalindrome(int k) {
        // Initialize a queue to perform BFS over palindromes
        Queue<String> q = new LinkedList<>();

        // Start with the smallest even-digit palindromes
        q.add("11");
        q.add("22");

        String ans = ""; // This will hold the final answer (k-th palindrome)

        // Generate palindromes using BFS for k iterations
        for (int i = 0; i < k; i++) {
            // Remove the front element from the queue
            String temp = q.remove();
            ans = temp; // Store current palindrome as potential result

            // Split the string into two equal halves
            String left = temp.substring(0, temp.length() / 2);
            String right = temp.substring(temp.length() / 2, temp.length());

            // Insert "11" and "22" in the middle to create new even-digit palindromes
            q.add(left + "11" + right);
            q.add(left + "22" + right);
        }

        // After k iterations, 'ans' holds the k-th even-digit palindrome
        return ans;
    }
}
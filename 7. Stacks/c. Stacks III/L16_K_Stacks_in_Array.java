public class L16_K_Stacks_in_Array {
    public static void main(String[] args) {
        int k = 3, n = 10; // Let us create 3 stacks in an array of size 10

        Stacks kStack = new Stacks(k, n);

        // Let us put some items in stack number 2
        kStack.push(15, 2);
        kStack.push(45, 2);

        // Let us put some items in stack number 1
        kStack.push(17, 1);
        kStack.push(49, 1);
        kStack.push(39, 1);

        // Let us put some items in stack number 0
        kStack.push(11, 0);
        kStack.push(9, 0);
        kStack.push(7, 0);

        System.out.println("Popped element from stack 2 is " + kStack.pop(2));
        System.out.println("Popped element from stack 1 is " + kStack.pop(1));
        System.out.println("Popped element from stack 0 is " + kStack.pop(0));
    }

    // A Java class to represent K_Stacks in a single array of size n
    static class Stacks {
        int arr[]; // Array of size n to store actual content to be stored in stacks
        int top[]; // Array of size k to store indexes of top elements of stacks
        int next[]; // Array of size n to store next entry in all stacks and free list
        int n, k;
        int free; // To store beginning index of free list

        // constructor to create k stacks in an array of size n
        Stacks(int k1, int n1) {
            // Initialize n and k, and allocate memory for all arrays
            k = k1;
            n = n1;
            arr = new int[n];
            top = new int[k];
            next = new int[n];

            // Initialize every stacks as empty
            for (int i = 0; i < k; i++) {
                top[i] = -1;
            }
            // Initialize all the spaces as free
            free = 0;
            for (int i = 0; i < n - 1; i++) {
                next[i] = i + 1;
            }
            next[n - 1] = -1; // -1 is used to indicate end of free list
        }

        // To push an item in stack number 'st' where st is from 0 to k-1
        void push(int val, int st) {
            if (free == -1) {
                System.out.println("Stack OverFlow");
                return;
            }

            int i = free; // Store index of first free slot

            // Update index of free slot to index of next slot in free list
            free = next[i];

            // Update next of top and then top for stack number 'st'
            next[i] = top[st];
            top[st] = i;

            // Put the item in array
            arr[i] = val;
        }

        // To pop an element from stack number 'st' where st is from 0 to k-1
        int pop(int st) {
            if (top[st] == -1) {
                System.out.println("Stack UnderFlow");
                return Integer.MAX_VALUE;
            }
            // Find index of top item in stack number 'st'
            int i = top[st];

            top[st] = next[i]; // Change top to store next of previous top

            // Attach the previous top to the beginning of free list
            next[i] = free;
            free = i;

            // Return the previous top item
            return arr[i];
        }
    }
}
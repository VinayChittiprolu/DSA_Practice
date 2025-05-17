import java.util.HashMap;
import java.util.Stack;

public class L13_Max_Freq_Stack {
    public static void main(String[] args) {
        FreqStack stack = new FreqStack();

        stack.push(5); // The stack is [5]
        stack.push(7); // The stack is [5,7]
        stack.push(5); // The stack is [5,7,5]
        stack.push(7); // The stack is [5,7,5,7]
        stack.push(4); // The stack is [5,7,5,7,4]
        stack.push(5); // The stack is [5,7,5,7,4,5]

        System.out.println("Popped: " + stack.pop()); // return 5, as 5 is the most frequent. The stack becomes
                                                      // [5,7,5,7,4]

        System.out.println("Popped: " + stack.pop()); // return 7, as 5 and 7 is the most frequent, but 7 is closest to
                                                      // the top. The stack becomes [5,7,5,4].

        System.out.println("Popped: " + stack.pop()); // return 5, as 5 is the most frequent. The stack becomes [5,7,4].

        System.out.println("Popped: " + stack.pop()); // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest
                                                      // to the top. The stack becomes [5,7].
    }

    public static class FreqStack {
        // Map to track the frequency of each value
        HashMap<Integer, Integer> frequencyMap;
        // Map to track stacks of values grouped by their frequency
        HashMap<Integer, Stack<Integer>> frequencyStackMap;
        // Keeps track of the current highest frequency
        int maxFrequency;

        // Constructor – Initializes all the internal data structures.
        public FreqStack() {
            frequencyStackMap = new HashMap<>();
            frequencyMap = new HashMap<>();
            maxFrequency = 0;
        }

        public void push(int val) {
            // Update frequency of the value
            int frequency = 1;
            if (frequencyMap.containsKey(val)) {
                frequency = frequencyMap.get(val) + 1;
            }
            frequencyMap.put(val, frequency);

            // Update max frequency if needed
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }

            // If no stack exists for this frequency, create one
            if (!frequencyStackMap.containsKey(frequency)) {
                frequencyStackMap.put(frequency, new Stack<>());
            }

            // Push the value onto the stack corresponding to its frequency
            frequencyStackMap.get(frequency).push(val);
        }

        public int pop() {
            // Get the stack of elements with the current max frequency
            Stack<Integer> stack = frequencyStackMap.get(maxFrequency);

            // Pop the most recent value
            int value = stack.pop();

            // Decrease its frequency in the frequency map
            int updatedFreq = frequencyMap.get(value) - 1;
            frequencyMap.put(value, updatedFreq);

            // If the stack becomes empty, decrease the max frequency
            if (stack.isEmpty()) {
                frequencyStackMap.remove(maxFrequency);
                maxFrequency--;
            }

            return value;
        }
    }
}
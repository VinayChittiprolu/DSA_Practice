public class F1a_Remove_Adjecent_Duplicates {
    public static void main(String[] args) {
        String input = "abbaca";
        System.out.println("Output: " + removeAdjacentDuplicates(input)); // "ca"
    }

    // Brute force method using string concatenation
    public static String removeAdjacentDuplicates(String input) {
        boolean hasDuplicates = true;

        // Keep repeating the process until no adjacent duplicates are found
        while (hasDuplicates) {
            hasDuplicates = false;
            String result = ""; // Will hold the new version of the string after one pass

            int i = 0;
            while (i < input.length()) {
                // Check if current character and next character are the same
                if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                    hasDuplicates = true; // Found adjacent duplicates
                    i += 2; // Skip both duplicates
                } else {
                    // No duplicate — add character to result
                    result = result + input.charAt(i);
                    i++;
                }
            }

            // Update input for the next pass
            input = result;
        }

        return input; // Final string with no adjacent duplicates
    }
}
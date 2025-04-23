public class L16_Count_Sort {
    public static void main(String[] args) {
        String str = "banana";
        String sortedStr = countSort(str);

        System.out.println("Sorted String  : " + sortedStr);
    }

    public static String countSort(String str) {
        // Convert the string to a character array
        char[] arr = str.toCharArray();
        char maxChar = 'a';

        // Find the maximum character in the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxChar) {
                maxChar = arr[i];
            }
        }

        // Calculate the size of the count array based on the maximum character
        int maxIndex = maxChar - 'a';
        int[] count = new int[maxIndex + 1];

        // Counting occurrences of each character
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            count[index]++;
        }

        // Sorting the characters by writing them back into the array
        int k = 0;
        for (int i = 0; i <= maxIndex; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k] = (char) (i + 'a');
                k++;
            }
        }

        return new String(arr);
    }
}
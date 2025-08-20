public class F1a_Frequency_Queries {
    public static void main(String[] args) {
        int[] arr = { 2, 8, 6, 9, 8, 6, 8, 2, 11 };
        int[] queries = { 2, 8 };
        System.out.println("First Queries: ");
        frequencyQueries(arr, queries); // 2 3

        int[] arr1 = { 1, 2, 2, 3, 3 };
        int[] queries1 = { 2, 3, 4 };
        System.out.println("Second Queries: ");
        frequencyQueries(arr1, queries1); // 2 2 0
    }

    public static void frequencyQueries(int[] arr, int[] queries) {
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (queries[i] == arr[j]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
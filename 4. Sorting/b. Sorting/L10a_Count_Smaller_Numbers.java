import java.util.ArrayList;
import java.util.List;

public class L10a_Count_Smaller_Numbers {
    public static void main(String[] args) {
        int[] nums = { 5, 2, 6, 1 };
        List<Integer> result = countSmaller(nums);
        System.out.println(result);
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] indexes = new int[n]; // To track original positions
        int[] count = new int[n]; // Counts of smaller elements to the right

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, indexes, count, 0, n - 1);

        // Convert counts[] to List<Integer>
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            output.add(count[i]);
        }
        return output;
    }

    // Merge sort on index array to track element positions
    private static void mergeSort(int[] nums, int[] indexes, int[] count, int s, int e) {
        if (s >= e)
            return;

        int m = s + (e - s) / 2;

        mergeSort(nums, indexes, count, s, m);
        mergeSort(nums, indexes, count, m + 1, e);
        
        merge(nums, indexes, count, s, m, e);
    }

    private static void merge(int[] nums, int[] indexes, int[] count, int s, int m, int e) {
        int[] tempIndexes = new int[e - s + 1];

        int i = s, j = m + 1, k = 0; // k is merged index
        int rightCount = 0; // Number of smaller elements from right subarray

        while (i <= m && j <= e) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                tempIndexes[k] = indexes[j];
                k++;
                j++;
                rightCount++;
            } else {
                count[indexes[i]] += rightCount; // Add count of smaller elements to the right
                tempIndexes[k] = indexes[i];
                k++;
                i++;
            }
        }

        while (i <= m) {
            count[indexes[i]] += rightCount;
            tempIndexes[k] = indexes[i];
            k++;
            i++;
        }

        while (j <= e) {
            tempIndexes[k] = indexes[j];
            k++;
            j++;
        }

        // Copy merged indexes back to original array
        for (int p = 0; p < tempIndexes.length; p++) {
            indexes[s + p] = tempIndexes[p];
        }
    }
}
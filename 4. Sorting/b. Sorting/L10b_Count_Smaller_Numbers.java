import java.util.ArrayList;
import java.util.List;

public class L10b_Count_Smaller_Numbers {
    public static void main(String[] args) {
        int[] nums = { 5, 2, 6, 1 };
        System.out.println(countSmaller(nums)); // Output: [2, 1, 1, 0]
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        int[] counts = new int[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        mergeSort(pairs, counts, 0, n - 1);

        // Convert counts array to List<Integer>
        List<Integer> result = new ArrayList<>(n);
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }

    private static void mergeSort(Pair[] pairs, int[] counts, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(pairs, counts, left, mid);
        mergeSort(pairs, counts, mid + 1, right);
        
        merge(pairs, counts, left, mid, right);
    }

    private static void merge(Pair[] pairs, int[] counts, int left, int mid, int right) {
        Pair[] merged = new Pair[right - left + 1];

        int i = left, j = mid + 1, k = 0; // k is merged index
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (pairs[j].value < pairs[i].value) {
                merged[k] = pairs[j];
                k++;
                j++;
                rightCount++;
            } else {
                counts[pairs[i].index] += rightCount;
                merged[k] = pairs[i];
                k++;
                i++;
            }
        }

        while (i <= mid) {
            counts[pairs[i].index] += rightCount;
            merged[k] = pairs[i];
            k++;
            i++;
        }

        while (j <= right) {
            merged[k] = pairs[j];
            k++;
            j++;
        }

        for (int p = 0; p < merged.length; p++) {
            pairs[left + p] = merged[p];
        }
    }
}

class Pair {
    int value; // Original element value
    int index; // Original position in the array

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
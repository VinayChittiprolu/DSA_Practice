import java.util.HashMap;

public class L1b_Subarray_Sum_K {
    public static void main(String[] args) {
        int num[] = { 1, 2, 3 };
        int k = 3;
        System.out.println("No. of subArrays: " + subArraySum(num, k));
    }

    public static int subArraySum(int[] num, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int n = num.length;
        int ans = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + num[i];

            if (map.containsKey(sum - k)) {
                ans = ans + map.getOrDefault(sum - k, 0);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
import java.util.ArrayList;
import java.util.List;

public class L18_Subsets {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        System.out.println(subSets(arr));

        int arr2[] = { 0 };
        System.out.println(subSets(arr2));
    }

    public static List<List<Integer>> subSets(int nums[]) {
        int n = nums.length;
        int total_no = (1 << n);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < total_no; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (checkBit(i, j) == true) {
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public static boolean checkBit(int n, int i) {
        if ((n & (1 << i)) != 0) {
            return true;
        }
        return false;
    }
}
import java.util.HashSet;

public class F3_Distinct_Element {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 20, 10, 30, 10 };
        System.out.println("No. of distance elements: " + countDistEle(arr));
    }

    public static int countDistEle(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set.size();
    }
}
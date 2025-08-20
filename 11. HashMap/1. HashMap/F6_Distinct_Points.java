import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class F6_Distinct_Points {
    public static void main(String[] args) {
        int[] x = { 2, 1, 3, 2, 2, 5 };
        int[] y = { 3, 1, 2, 0, 4, 6 };
        System.out.println(maxPoints(x, y));

        int[] x1 = { 1, 2, 1, 2 };
        int[] y1 = { 3, 4, 3, 5 };
        System.out.println(maxPoints(x1, y1));
    }

    public static long maxPoints(int[] x, int[] y) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < x.length; i++) {
            set.add(x[i] + " " + y[i]);
        }
        return set.size();
    }

    public static long maxPoints2(int[] x, int[] y) {
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < x.length; i++) {
            List<Integer> point = Arrays.asList(x[i], y[i]);
            set.add(point); // HashSet will ignore duplicates
        }

        return set.size(); // Number of unique points
    }
}
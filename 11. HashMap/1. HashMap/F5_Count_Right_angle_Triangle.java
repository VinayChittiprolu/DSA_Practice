import java.util.HashMap;

public class F5_Count_Right_angle_Triangle {
    public static void main(String[] args) {
        int[][] arr = { { 4, 2 },
                { 2, 1 },
                { 1, 3 } };
        int n = 3;
        System.out.println(rightAngled(arr, n));

        int arr1[][] = { { 1, 2 }, { 2, 1 },
                { 2, 2 }, { 2, 3 },
                { 3, 2 } };
        int n1 = 5;
        System.out.println(rightAngled(arr1, n1));
    }

    public static int rightAngled(int[][] a, int n) {
        // HashMaps to count occurrences of x-coordinates and y-coordinates
        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();

        // Loop to populate the hash maps with the frequency of each x and y coordinate
        for (int i = 0; i < n; i++) {
            int x = a[i][0]; // x-coordinate
            int y = a[i][1]; // y-coordinate

            // Increment count for x-coordinate a[i][0]
            if (mapX.containsKey(x)) {
                mapX.put(x, mapX.get(x) + 1);
            } else {
                mapX.put(x, 1);
            }
            // Increment count for y-coordinate a[i][1]
            if (mapY.containsKey(y)) {
                mapY.put(y, mapY.get(y) + 1);
            } else {
                mapY.put(y, 1);
            }
        }

        int count = 0;

        // Loop to count the number of right-angled triangles
        for (int i = 0; i < n; i++) {
            int x = mapX.get(a[i][0]); // Get the count of points with the same x-coordinate
            int y = mapY.get(a[i][1]); // Get the count of points with the same y-coordinate

            // Each point can form (x - 1) * (y - 1) right-angled triangles
            count += (x - 1) * (y - 1);
        }
        return count;
    }
}
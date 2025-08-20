import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class F2_Brick_Wall {
    public static void main(String[] args) {
        int wall[][] = { { 1, 2, 2, 1 },
                { 3, 1, 2 },
                { 1, 3, 2 },
                { 2, 4 },
                { 3, 1, 2 },
                { 1, 3, 1, 1 } };

        // Convert the 2D array to List<List<Integer>>
        List<List<Integer>> wallList = new ArrayList<>();
        for (int i = 0; i < wall.length; i++) {
            List<Integer> listRow = new ArrayList<>();
            for (int j = 0; j < wall[i].length; j++) {
                listRow.add(wall[i][j]);
            }
            wallList.add(listRow);
        }

        System.out.println(leastBricks(wallList));
    }

    public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxFreq = 0; 

        // Iterate through each row of the wall
        for (List<Integer> row : wall) {
            int prefix = 0;

            // Calculate prefix sums for each brick in the row except the last one
            for (int i = 0; i < row.size() - 1; i++) {
                prefix += row.get(i); 
                count.put(prefix, count.getOrDefault(prefix, 0) + 1);
                // Update the maximum frequency of any prefix sum
                maxFreq = Math.max(maxFreq, count.get(prefix));
            }
        }
        // Return the minimum number of bricks that a vertical line would intersect
        return wall.size() - maxFreq;
    }
}
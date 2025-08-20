import java.util.HashMap;

public class F1_Lamps {
    public static void main(String[] args) {
        int n = 5;
        int[][] lamps = { { 2, 5 }, { 4, 2 }, { 0, 3 }, { 0, 5 }, { 1, 4 }, { 4, 2 }, { 3, 3 }, { 1, 0 } };
        int[][] queries = { { 4, 3 }, { 3, 1 }, { 5, 3 }, { 0, 5 }, { 4, 4 }, { 3, 3 } };

        int[] result = gridIllumination(n, lamps, queries);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> rowMap = new HashMap<>(); // Row map to count lamps in each row
        HashMap<Integer, Integer> colMap = new HashMap<>(); // Column map to count lamps in each column
        HashMap<Integer, Integer> diagMap = new HashMap<>(); // Diagonal map to count lamps in each diagonal (x - y)
        HashMap<Integer, Integer> antiDiagMap = new HashMap<>(); // Anti-diagonal map to count lamps in each
                                                                 // anti-diagonal (x + y)
        HashMap<Integer, Integer> lampMap = new HashMap<>(); // Map to count lamps at specific coordinates (x * n + y)

        // Initialize the maps with the lamp positions
        for (int i = 0; i < lamps.length; i++) {
            int x = lamps[i][0]; // Row index of the lamp
            int y = lamps[i][1]; // Column index of the lamp

            // increment the counts in the respective maps
            rowMap.put(x, rowMap.getOrDefault(x, 0) + 1);
            colMap.put(y, colMap.getOrDefault(y, 0) + 1);
            diagMap.put(x - y, diagMap.getOrDefault(x - y, 0) + 1);
            antiDiagMap.put(x + y, antiDiagMap.getOrDefault(x + y, 0) + 1);
            lampMap.put(x * n + y, lampMap.getOrDefault(x * n + y, 0) + 1);
        }

        // Directions for checking adjacent lamps
        int[][] d = { { -1, 0 }, { -1, 1 }, { 0, 1 },
                { 1, 1 }, { 1, 0 }, { 1, -1 },
                { 0, -1 }, { -1, -1 }, { 0, 0 } };

        int result[] = new int[queries.length]; // Result array to store the illumination status for each query

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0]; // Row index of the query
            int y = queries[i][1]; // Column index of the query

            // Check if the current position is illuminated
            if (rowMap.getOrDefault(x, 0) > 0 || colMap.getOrDefault(y, 0) > 0 ||
                    diagMap.getOrDefault(x - y, 0) > 0 || antiDiagMap.getOrDefault(x + y, 0) > 0 ||
                    lampMap.getOrDefault(x * n + y, 0) > 0) {
                result[i] = 1; // Position is illuminated
            }

            // Remove the lamps in the adjacent positions
            for (int j = 0; j < d.length; j++) {
                int x1 = x + d[j][0]; // Calculate the new row index
                int y1 = y + d[j][1]; // Calculate the new column index

                // Check if the new position is within bounds and has a lamp
                if (x1 >= 0 && y1 >= 0 && y1 < n && x1 < n && lampMap.containsKey(x1 * n + y1) == true) {
                    int times = lampMap.get(x1 * n + y1); // Get the number of lamps at this position

                    // Update the maps by decrementing the counts for the row, column, diagonal,
                    // anti-diagonal, and specific lamp position
                    rowMap.put(x1, rowMap.getOrDefault(x1, 0) - times);
                    colMap.put(y1, colMap.getOrDefault(y1, 0) - times);
                    diagMap.put(x1 - y1, diagMap.getOrDefault(x1 - y1, 0) - times);
                    antiDiagMap.put(x1 + y1, antiDiagMap.getOrDefault(x1 + y1, 0) - times);
                    lampMap.remove(x1 * n + y1);
                }
            }
        }
        return result;
    }
}
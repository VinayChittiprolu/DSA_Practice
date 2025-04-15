import java.util.ArrayList;
import java.util.List;

public class L42_Print_Boundary {
	public static void main(String[] args) {
		int arr[][] = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		System.out.println(SpiralMatrixTraversal(arr));

		int arr2[][] = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }
		};
		System.out.println(SpiralMatrixTraversal(arr2));
	}

	public static List<Integer> SpiralMatrixTraversal(int[][] arr) {
		List<Integer> result = new ArrayList<>();
		int n = arr.length;
		int m = arr[0].length;
		int row = 0;
		int col = 0;

		for (int k = 0; k < m - 1; k++) {
			result.add(arr[row][col]);
			col++;
		}

		for (int k = 0; k < n - 1; k++) {
			result.add(arr[row][col]);
			row++;
		}

		for (int k = 0; k < m - 1; k++) {
			result.add(arr[row][col]);
			col--;
		}

		for (int k = 0; k < n - 1; k++) {
			result.add(arr[row][col]);
			row--;
		}
		return result;
	}
}
import java.util.ArrayList;
import java.util.List;

public class L43b_Print_Spiral_Matrix {
	public static void main(String[] args) {
		int[][] arr = {
				{ 1, 2, 3, 4, 5 },
				{ 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 }
		};
		System.out.println(spiralOrder(arr));
	}

	public static List<Integer> spiralOrder(int[][] arr) {
		List<Integer> result = new ArrayList<>();
		int n = arr.length;
		int m = arr[0].length;
		int top = 0, left = 0, bottom = n - 1, right = m - 1;

		while (top <= bottom && left <= right) {
			// Traverse from left to right
			for (int j = left; j <= right; j++) {
				result.add(arr[top][j]);
			}
			top++;

			// Traverse from top to bottom
			for (int i = top; i <= bottom; i++) {
				result.add(arr[i][right]);
			}
			right--;

			// Traverse from right to left (only if there's a row left)
			if (top <= bottom) {
				for (int j = right; j >= left; j--) {
					result.add(arr[bottom][j]);
				}
				bottom--;
			}

			// Traverse from bottom to top (only if there's a column left)
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					result.add(arr[i][left]);
				}
				left++;
			}
		}

		return result; // Now we need a print statement!
	}

}
public class L43a_Print_Spiral_Matrix {
	public static void main(String[] args) {
		int[][] arr = {
				{ 1, 2, 3, 4, 5 },
				{ 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 }
		};

		spiralMatrix(arr);
	}

	public static void spiralMatrix(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int top = 0, left = 0, bottom = n - 1, right = m - 1;

		while (top <= bottom && left <= right) {
			// Traverse from left to right
			for (int j = left; j <= right; j++) {
				System.out.print(arr[top][j] + " ");
			}
			top++;

			// Traverse from top to bottom
			for (int i = top; i <= bottom; i++) {
				System.out.print(arr[i][right] + " ");
			}
			right--;

			// Traverse from right to left (only if there's a row left)
			if (top <= bottom) {
				for (int j = right; j >= left; j--) {
					System.out.print(arr[bottom][j] + " ");
				}
				bottom--;
			}

			// Traverse from bottom to top (only if there's a column left)
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(arr[i][left] + " ");
				}
				left++;
			}
		}
	}
}
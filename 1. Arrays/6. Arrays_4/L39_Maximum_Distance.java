public class L39_Maximum_Distance {
	public static void main(String[] args) {
		int arr[] = { 1, 0, 0, 0, 1, 0, 1 };
		System.out.println("Maximum Distance is: " + maxDistToClosest(arr));

		int arr1[] = { 1, 0, 0, 0 };
		System.out.println("Maximum Distance is: " + maxDistToClosest(arr1));

		int arr2[] = { 0, 1 };
		System.out.println("Maximum Distance is: " + maxDistToClosest(arr2));
	}

	public static int maxDistToClosest(int[] seats) {
		int n = seats.length;

		int distance = 0;
		int occupied = -1;

		for (int i = 0; i < n; i++) {
			if (seats[i] == 1) {
				if (occupied == -1) {
					distance = i; // distance is i, for the first occupied seat
				} else {
					distance = Math.max(distance, (i - occupied) / 2); // Maximum Distance between two occupied seats
				}
				occupied = i;
			}
		}

		// Check the distance from the last occupied seat to the end
		distance = Math.max(distance, n - 1 - occupied);

		return distance;
	}
}
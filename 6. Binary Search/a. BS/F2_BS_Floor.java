public class F2_BS_Floor {
    public static void main(String[] args) {
        int[] arr = { -4, 3, 4, 7, 10, 11, 12, 15, 19 };
        int key = 5;

        System.out.println("Floor of " + key + " is: " + findFloor(arr, key));
    }

    public static int findFloor(int arr[], int key) {
        int left = 0;
        int right = arr.length - 1;
        int floor = -1; // Initialize to -1 to indicate "no floor found"

        while (left <= right) {
            int mid = left + (right - left) / 2; // Safer mid calculation

            if (arr[mid] == key) {
                return arr[mid]; // Exact match found, return it immediately
            } else if (arr[mid] < key) {
                floor = arr[mid]; // arr[mid] could be the floor, but let's search for a bigger candidate
                left = mid + 1;
            } else {
                right = mid - 1; // arr[mid] is too big, move search to the left half
            }
        }

        return floor; // After the loop, floor contains the greatest value <= key, or -1 if none
                      // exists
    }
}
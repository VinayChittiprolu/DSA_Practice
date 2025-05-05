public class L7_Painters_Partition {
    public static void main(String[] args) {
        int arr[] = { 5, 10, 30, 20, 15 };
        int days = 3;
        System.out.println("Minimum time to get the job done: " + minTime(arr, days));

        int arr1[] = { 10, 20, 30, 40 };
        int days1 = 2;
        System.out.println("Minimum time to get the job done: " + minTime(arr1, days1));
    }

    public static long minTime(int[] arr, int k) {
        long left = 0;
        long right = 0;
        long result = 0;

        for (int i = 0; i < arr.length; i++) {
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (calculate(arr, mid) <= k) {
                result = mid;
                right = mid - 1; // try to find smaller maximum
            } else {
                left = mid + 1; // need more capacity per painter
            }
        }
        return result;
    }

    public static long calculate(int[] arr, long mid) {
        long painters = 1;
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > mid) {
                painters++;
                sum = 0;
            }
            sum += arr[i];
        }

        return painters;
    }
}
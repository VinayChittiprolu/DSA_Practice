public class L9_Allocate_Books {
    public static void main(String[] args) {
        int[] arr = { 12, 34, 67, 90 };
        int students1 = 2;
        System.out.println("Minimum possible max pages: " + findPages(arr, students1));

        int[] arr1 = { 15, 17, 20 };
        int students2 = 2;
        System.out.println("Minimum possible max pages: " + findPages(arr1, students2));
    }

    public static int findPages(int[] arr, int students) {
        if (arr.length < students) {
            return -1;
        }

        int left = 0;
        int right = 0;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (requiredStudents(arr, mid) <= students) {
                result = mid;
                right = mid - 1; // This distribution is valid, try to minimize further
            } else {
                left = mid + 1; // Too many students needed, increase allowed max
            }
        }
        return result;
    }

    // Helper function to count how many students are needed if max pages per student is 'mid'
    public static int requiredStudents(int[] pages, int mid) {
        int students = 1;
        int currentPageSum = 0;

        for (int i = 0; i < pages.length; i++) {
            if (currentPageSum + pages[i] > mid) {
                students++;
                currentPageSum = pages[i];
            } else {
                currentPageSum += pages[i];
            }
        }
        return students;
    }
}
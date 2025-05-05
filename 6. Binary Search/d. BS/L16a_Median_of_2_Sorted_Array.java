public class L16a_Median_of_2_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        System.out.println(findMedianSortedArrays(nums1, nums2));

        int[] nums_a = { 1, 2 };
        int[] nums_b = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums_a, nums_b));

        int[] a = { 1, 4, 7, 10, 12, 14 };
        int[] b = { 2, 3, 6, 15, 17, 19, 21 };
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;

        // Merge elements from both arrays in sorted order
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        while (i < n) {
            merged[k++] = nums1[i++];
        }
        while (j < m) {
            merged[k++] = nums2[j++];
        }

        // Find median
        int total = n + m;
        if (total % 2 == 0) {
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        } else {
            return merged[total / 2];
        }
    }
}
// Similar to 6th problem from Sorting
public class L4_Sort_Colours {
    public static void main(String[] args) {
        int arr[] = { 2, 0, 2, 1, 1, 0 };
        
        SortColours(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void SortColours(int nums[]) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 0) {
                Swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else {
                Swap(nums, j, k);
                k--;
            }
        }
    }

    public static void Swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
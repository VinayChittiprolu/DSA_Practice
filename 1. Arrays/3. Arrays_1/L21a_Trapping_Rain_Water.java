public class L21a_Trapping_Rain_Water {
    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 3, 2, 5 };
        System.out.println("Trapped Rain Water: " + trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        
        // Compute leftMax array
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        // Compute rightMax array
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        // Calculate trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }
}
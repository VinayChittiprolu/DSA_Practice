public class L21b_Trapping_Rain_Water {
   public static void main(String[] args) {
      int height[] = { 4, 2, 0, 3, 2, 5 };
      System.out.println("Trapped Rain Water: " + trap(height));
   }

   public static int trap(int[] height) {
      int sp = 0;
      int ep = height.length - 1;

      int leftMax = -1; // Maximum height encountered from the left side
      int rightMax = -1; // Maximum height encountered from the right side
      int trappedWater = 0;

      // Traverse the array until the pointers meet
      while (sp < ep) {
         // Update the maximum heights encountered so far
         leftMax = Math.max(leftMax, height[sp]);
         rightMax = Math.max(rightMax, height[ep]);

         // Calculate trapped water based on the smaller maximum height
         if (leftMax < rightMax) {
            trappedWater += leftMax - height[sp];
            sp++;
         } else {
            trappedWater += rightMax - height[ep];
            ep--;
         }
      }
      return trappedWater;
   }
}
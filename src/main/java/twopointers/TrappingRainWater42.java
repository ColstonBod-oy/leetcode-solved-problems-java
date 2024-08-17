package twopointers;

public class TrappingRainWater42 {
  public int trap(int[] height) {
    int res = 0;
    int leftPtr = 0;
    int rightPtr = height.length - 1;
    int maxLeft = height[leftPtr];
    int maxRight = height[rightPtr];

    while (leftPtr < rightPtr - 1) {
      if (maxLeft > maxRight) {
        --rightPtr;
        
        if (maxRight - height[rightPtr] < 0) {
          maxRight = height[rightPtr];
          continue;
        }
                
        res += maxRight - height[rightPtr];
      }

      else {
        ++leftPtr;
        
        if (maxLeft - height[leftPtr] < 0) {
          maxLeft = height[leftPtr];
          continue;
        }
                
        res += maxLeft - height[leftPtr];
      }
    }

    return res;
  }
}
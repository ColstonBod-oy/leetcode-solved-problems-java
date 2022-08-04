class TrappingRainWater42 {
  public int trap(int[] height) {
    int res = 0;
    int leftPtr = 0;
    int rightPtr = height.length - 1;
    int maxLeft = height[leftPtr];
    int maxRight = height[rightPtr];

    while (leftPtr < rightPtr - 1) {
      if (maxLeft > maxRight) {
        --rightPtr;
        res += Math.max(0, maxRight - height[rightPtr]);

        if (height[rightPtr] > maxRight) {
          maxRight = height[rightPtr];
        }
      }

      else {
        ++leftPtr;
        res += Math.max(0, maxLeft - height[leftPtr]);

        if (height[leftPtr] > maxLeft) {
          maxLeft = height[leftPtr];
        }
      }
    }

    return res;
  }
}
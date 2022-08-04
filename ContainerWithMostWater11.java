class ContainerWithMostWater11 {
  public int maxArea(int[] height) {
    int res = 0;
    int leftPtr = 0;
    int rightPtr = height.length - 1;    

    while (leftPtr < rightPtr) {
      if ((rightPtr - leftPtr) * Math.min(height[leftPtr], height[rightPtr]) > res) {
        res = (rightPtr - leftPtr) * Math.min(height[leftPtr], height[rightPtr]);
      }

      if (height[leftPtr] > height[rightPtr]) {
        --rightPtr;
      }

      else {
        ++leftPtr;
      }
    }

    return res;
  }
}
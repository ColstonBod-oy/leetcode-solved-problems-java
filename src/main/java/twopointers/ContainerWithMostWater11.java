package twopointers;

public class ContainerWithMostWater11 {
  public int maxArea(int[] height) {
    int res = 0;
    int leftPtr = 0;
    int rightPtr = height.length - 1;  

    while (leftPtr < rightPtr) {
      int leftHeight = height[leftPtr];
      int rightHeight = height[rightPtr];
      int areaLeft = (rightPtr - leftPtr) * leftHeight;
      int areaRight = (rightPtr - leftPtr) * rightHeight;
            
      if (leftHeight > rightHeight) {
        if (areaRight > res) {
          res = areaRight;
        }
                
        --rightPtr;
      }
            
      else {
        if (areaLeft > res) {
          res = areaLeft;
        }
                
        ++leftPtr;
      }
    }

    return res;
  }
}
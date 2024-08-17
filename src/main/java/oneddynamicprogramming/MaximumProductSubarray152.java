package oneddynamicprogramming;

public class MaximumProductSubarray152 {
  public int maxProduct(int[] nums) {
    int res = Integer.MIN_VALUE;
    int curMax = 1;
    int curMin = 1;
    
    for (int n : nums) {
      int tmp = curMax * n;

      curMax = Math.max(Math.max(curMax * n, 
                                 curMin * n), n);
      curMin = Math.min(Math.min(tmp, curMin * n), n);
      res = Math.max(res, curMax);
    }

    return res;
  }
}
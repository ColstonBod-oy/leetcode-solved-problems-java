package twoddynamicprogramming;

import java.util.HashMap;

public class TargetSum494 {
  HashMap<String, Integer> dp = new HashMap<>();

  public int findTargetSumWays(int[] nums, int target, 
                               int i, int total) {
    if (i == nums.length) {
      return (total == target) ? 1 : 0;
    }

    String status = i + "" + total;
    
    if (dp.containsKey(status)) {
      return dp.get(status);
    }

    dp.put(status, 
           findTargetSumWays(nums, target, 
                             i + 1, total + nums[i]) 
           + findTargetSumWays(nums, target, 
                               i + 1, total - nums[i]));

    return dp.get(status);
  }
  
  public int findTargetSumWays(int[] nums, int target) {
    return findTargetSumWays(nums, target, 0, 0);
  }
}
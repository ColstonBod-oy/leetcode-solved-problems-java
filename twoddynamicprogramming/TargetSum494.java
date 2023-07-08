package twoddynamicprogramming;

public class TargetSum494 {
  public int subsetSum(int[] nums, int targetSum) {
    int[] dp = new int[targetSum + 1];
    dp[0] = 1;

    for (int n : nums) {
      for (int i = targetSum; i >= n; i--) {
        dp[i] += dp[i - n]; 
      }
    }

    return dp[targetSum];
  }
  
  public int findTargetSumWays(int[] nums, int target) {
    int targetSum = 0;

    for (int n : nums) {
      targetSum += n;
    }

    return (targetSum < target 
              || targetSum + target < 0
              || (targetSum + target) % 2 != 0) 
           ? 0
           : subsetSum(nums, (targetSum + target) / 2);
  }
}
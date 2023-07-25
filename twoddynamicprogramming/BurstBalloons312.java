package twoddynamicprogramming;

public class BurstBalloons312 {
  public int maxCoins(int[][] dp, int[] nums, 
                      int l, int r) {
    if (l > r) {
      return 0;
    }

    if (dp[l][r] != 0) {
      return dp[l][r];
    }

    for (int i = l; i <= r; i++) {
      int coins = nums[i];

      if (l - 1 >= 0) {
        coins *= nums[l - 1];
      }

      if (r + 1 < nums.length) {
        coins *= nums[r + 1];
      }
      
      coins += maxCoins(dp, nums, i + 1, r) 
               + maxCoins(dp, nums, l, i - 1);
      dp[l][r] = Math.max(dp[l][r], coins);
    }

    return dp[l][r];
  }
  
  public int maxCoins(int[] nums) {
    int[][] dp = new int[nums.length][nums.length];
    
    return maxCoins(dp, nums, 0, nums.length - 1);
  }
}
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
      int coins = nums[l - 1] * nums[i] * nums[r + 1];
      coins += maxCoins(dp, nums, i + 1, r) 
               + maxCoins(dp, nums, l, i - 1);
      dp[l][r] = Math.max(dp[l][r], coins);
    }

    return dp[l][r];
  }
  
  public int maxCoins(int[] nums) {
    int[] numsCopy = new int[nums.length + 2];
    numsCopy[0] = 1;
    numsCopy[numsCopy.length - 1] = 1;

    for (int i = 1; i <= nums.length; i++) {
      numsCopy[i] = nums[i - 1];
    }

    int[][] dp = new int[numsCopy.length][numsCopy.length];
    
    return maxCoins(dp, numsCopy, 1, numsCopy.length - 2);
  }
}
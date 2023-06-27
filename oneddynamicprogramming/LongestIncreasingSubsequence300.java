package oneddynamicprogramming;

public class LongestIncreasingSubsequence300 {
  public int lengthOfLIS(int[] nums) {
    int curMax = 0;
    int[] dp = new int[nums.length]; 

    for (int i = nums.length - 1; i >=0; i--) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] < nums[j]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
          curMax = Math.max(curMax, dp[i]);
        }
      }
    }

    return curMax + 1;
  }
}
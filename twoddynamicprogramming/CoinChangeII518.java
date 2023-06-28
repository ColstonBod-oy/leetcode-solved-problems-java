package twoddynamicprogramming;

import java.util.Arrays;

public class CoinChangeII518 {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int i = coins.length - 1; i >= 0; i--) {
      int[] newDP = Arrays.copyOf(dp, dp.length);

      for (int a = 1; a < amount + 1; a++) {
        if (a - coins[i] >= 0) {
          newDP[a] += newDP[a - coins[i]];  
        }
      }

      dp = newDP;
    }

    return dp[amount];
  }
}
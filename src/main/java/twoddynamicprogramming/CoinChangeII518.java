package twoddynamicprogramming;

public class CoinChangeII518 {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int a = 1; a < amount + 1; a++) {
        if (coin <= a) {
          dp[a] += dp[a - coin];  
        }
      }
    }

    return dp[amount];
  }
}
package twoddynamicprogramming;

import java.util.Arrays;

public class DistinctSubsequences115 {
  public int numDistinct(String s, String t, 
                         int[][] dp, int i, int j) {
    if (j == t.length()) {
      return 1;
    }

    if (i == s.length()) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    if (s.charAt(i) == t.charAt(j)) {
      dp[i][j] = numDistinct(s, t, dp, i + 1, j + 1) 
                 + numDistinct(s, t, dp, i + 1, j); 
    } else {
      dp[i][j] = numDistinct(s, t, dp, i + 1, j);
    }

    return dp[i][j];
  }
  
  public int numDistinct(String s, String t) {
    int[][] dp = new int[s.length()][t.length()];
    
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    
    return numDistinct(s, t, dp, 0, 0);
  }
}
package twoddynamicprogramming;

public class InterleavingString97 {
  public boolean isInterleave(String s1, 
                              String s2, String s3) {
    int lenS1 = s1.length();
    int lenS2 = s2.length();
    
    if (lenS1 + lenS2 != s3.length()) {
      return false;
    }
    
    boolean[][] dp = new boolean[lenS1 + 1]
                                [lenS2 + 1];
    dp[lenS1][lenS2] = true;

    for (int i = lenS1; i >= 0; i--) {
      for (int j = lenS2; j >= 0; j--) {
        if (i < lenS1 
              && s1.charAt(i) == s3.charAt(i + j) 
              && dp[i + 1][j]) {
          dp[i][j] = true;
        }

        if (j < lenS2 
              && s2.charAt(j) == s3.charAt(i + j) 
              && dp[i][j + 1]) {
          dp[i][j] = true;
        }
      }
    }

    return dp[0][0];
  }
}
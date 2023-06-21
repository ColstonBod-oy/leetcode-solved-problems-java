package oneddynamicprogramming;

public class DecodeWays91 {
  public int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    dp[s.length()] = 1;

    return numDecodings(s, dp, 0);
  }

  public int numDecodings(String s, int[] dp, int i) {
    int res = 0;
    
    if (dp[i] != 0) {
      return dp[i];
    }

    if (s.charAt(i) == '0') {
      return 0;
    }

    res = numDecodings(s, dp, i + 1);

    if (i + 1 < s.length() && (s.charAt(i) == '1' 
        || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
      res += numDecodings(s, dp, i + 2);
    }

    dp[i] = res;

    return res;
  }
}
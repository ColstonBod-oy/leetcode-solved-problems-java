package twoddynamicprogramming;

public class LongestIncreasingPathInAMatrix329 {
  public int longestIncreasingPath(int[][] matrix, 
      int[][] dp, int r, int c, int prev) {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    if (r < 0 || c < 0 
          || r == matrix.length 
          || c == matrix[0].length 
          || prev >= matrix[r][c]) {
      return 0;  
    }

    if (dp[r][c] != 0) {
      return dp[r][c];
    }
    
    int res = 1;
    
    for (int[] mod : dirs) {
      res = Math.max(res, 
                1 + longestIncreasingPath(matrix, dp, 
                        r + mod[0], c + mod[1], 
                        matrix[r][c]));
    }

    dp[r][c] = res;
    return res;
  }
  
  public int longestIncreasingPath(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    int res = 1;
    
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        res = Math.max(res, longestIncreasingPath(matrix, 
                                dp, i, j, -1));
      }
    }

    return res;
  }  
}
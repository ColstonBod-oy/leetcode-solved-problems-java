package graphs;

import java.util.List;
import java.util.HashSet;

public class MaxAreaOfIsland695 {
  HashSet<List<Integer>> visited = new HashSet<>();
  int maxArea = 0;
  
  public int maxAreaOfIsland(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        maxArea = Math.max(maxArea, 
                    maxAreaOfIsland(grid, i, j));
      }
    }

    return maxArea;
  }

  public int maxAreaOfIsland(int[][] grid, int r, int c) {
    if (r < 0 || c < 0 || r == grid.length || 
        c == grid[0].length || grid[r][c] == 0 ||
        visited.contains(List.of(r, c))) {
          return 0;  
    }

    visited.add(List.of(r, c));
    return (1 + maxAreaOfIsland(grid, r + 1, c) +
                maxAreaOfIsland(grid, r - 1, c) +
                maxAreaOfIsland(grid, r, c + 1) +
                maxAreaOfIsland(grid, r, c - 1));
  }
}
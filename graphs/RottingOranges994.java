package graphs;

import java.util.Deque;
import java.util.ArrayDeque;

public class RottingOranges994 {
  public int orangesRotting(int[][] grid) {
    Deque<int[]> dq = new ArrayDeque<>();
    int fresh = 0, time = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          ++fresh;
        }

        if (grid[i][j] == 2) {
          dq.offerLast(new int[]{i, j});
        }
      }
    }

    int[][] dirs = {{1, 0}, {-1, 0}, 
                    {0, 1}, {0, -1}};
    
    while (!dq.isEmpty() && fresh > 0) {
      for (int i = dq.size(); i > 0; i--) {
        int[] coor = dq.pollFirst();

        for (int[] mods : dirs) {
          int r = coor[0] + mods[0];
          int c = coor[1] + mods[1];
          
          if (r < 0 || c < 0 || 
              r == grid.length || 
              c == grid[0].length || 
              grid[r][c] != 1) {
                continue;
          }

          grid[r][c] = 2;
          dq.offerLast(new int[]{r, c});
          --fresh;
        }
      }

      ++time;
    }

    return fresh == 0 ? time : -1;
  }
}
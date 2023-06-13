package advancedgraphs;

import java.util.PriorityQueue;

public class SwimInRisingWater778 {
  public int swimInWater(int[][] grid) {
    int n = grid.length;

    if (n == 1) {
      return 0;
    }
    
    int[][] directions = new int[][] {{0, 1}, {0, -1}, 
                                      {1, 0}, {-1, 0}};

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) 
        -> Integer.compare(a[0], b[0]));
    
    pq.offer(new int[] {grid[0][0], 0, 0});

    boolean[][] visited = new boolean[n][n];
    visited[0][0] = true;

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();

      if (cur[1] == n - 1 
            && cur[2] == n - 1) {
        return cur[0];
      }

      for (int[] direction : directions) {
        int rn = cur[1] + direction[0];
        int cn = cur[2] + direction[1];

        if (rn < 0 || cn < 0 
              || rn == n 
              || cn == n 
              || visited[rn][cn]) {
          continue;
        }

        pq.offer(new int[] {Math.max(cur[0], 
            grid[rn][cn]), rn, cn});

        visited[rn][cn] = true;
      }
    }

    return 0;
  }
}
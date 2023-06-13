package advancedgraphs;

import java.util.List;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SwimInRisingWater778 {
  public int swimInWater(int[][] grid) {
    int n = grid.length;
    int[][] directions = new int[][] {{0, 1}, {0, -1}, 
                                      {1, 0}, {-1, 0}};

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) 
        -> Integer.compare(a[0], b[0]));
    
    pq.offer(new int[] {grid[0][0], 0, 0});

    HashSet<List<Integer>> visited = new HashSet<>();
    
    visited.add(List.of(0, 0));

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
              || visited.contains(List.of(rn, cn))) {
          continue;
        }

        pq.offer(new int[] {Math.max(cur[0], 
            grid[rn][cn]), rn, cn});

        visited.add(List.of(rn, cn));
      }
    }

    return 0;
  }
}
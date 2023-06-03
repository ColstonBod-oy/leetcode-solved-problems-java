package graphs;

import java.util.List;
import java.util.Deque;
import java.util.HashSet;
import java.util.ArrayDeque;

public class WallsAndGates663 {
  /**
   * @param rooms: m x n 2D grid
   * @return: nothing
   */
  Deque<int[]> dq = new ArrayDeque<>();
  HashSet<List<Integer>> visited = new HashSet<>();
  
  public void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] == 0) {
          dq.offerLast(new int[]{i, j});
          visited.add(List.of(i, j));
        }
      }
    }

    int dist = 0;
    
    while (!dq.isEmpty()) {
      for (int i = dq.size(); i > 0; i--) {
        int[] coor = dq.pollFirst();
        rooms[coor[0]][coor[1]] = dist;
        
        wallsAndGates(rooms, coor[0] + 1, coor[1]);
        wallsAndGates(rooms, coor[0] - 1, coor[1]);
        wallsAndGates(rooms, coor[0], coor[1] + 1);
        wallsAndGates(rooms, coor[0], coor[1] - 1);
      }

      ++dist;
    }
  }

  public void wallsAndGates(int[][] rooms, int r, int c) {
    if (r < 0 || c < 0 || 
        r == rooms.length || 
        c == rooms[0].length ||
        visited.contains(List.of(r, c)) || 
        rooms[r][c] == -1) {
          return;  
    }

    dq.offerLast(new int[]{r, c});
    visited.add(List.of(r, c));
  }
}
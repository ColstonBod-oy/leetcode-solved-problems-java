import java.util.List;
import java.util.Deque;
import java.util.HashSet;
import java.util.ArrayDeque;

class NumberOfIslands200 {
  public int numIslands(char[][] grid) {
    if (grid.length == 0) return 0;
    
    int islands = 0;
    HashSet<List<Integer>> visited = new HashSet<>();
    
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1' && 
            !visited.contains(List.of(i, j))) {
              Deque<int[]> q = new ArrayDeque<>();
              visited.add(List.of(i, j));
              q.offerFirst(new int[]{i, j});

              while (!q.isEmpty()) {
                int[] coor = q.pollFirst();  
                int[][] directions = {{-1, 0}, {1, 0}, 
                                      {0, 1}, {0, -1}};
                  
                for (int[] mod : directions) {
                  int r = coor[0] + mod[0];
                  int c = coor[1] + mod[1];

                  if (c >= 0 && c < grid[0].length &&
                      r >= 0 && r < grid.length && 
                      grid[r][c] == '1' &&
                      !visited.contains(List.of(r, c))) {
                        visited.add(List.of(r, c));
                        q.offerFirst(new int[]{r, c});
                  }
                }
              }

              islands += 1;
        }
      }
    }

    return islands;
  }
}
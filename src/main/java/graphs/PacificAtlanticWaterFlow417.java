package graphs;

import java.util.List;
import java.util.ArrayList;

public class PacificAtlanticWaterFlow417 {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    boolean[][] pacOcean = new boolean
      [heights.length][heights[0].length];
    boolean[][] atlOcean = new boolean
      [heights.length][heights[0].length];
    List<List<Integer>> res = new ArrayList<>();
    
    for (int i = 0; i < heights.length; i++) {
      pacificAtlantic(heights, i, 0, 
        pacOcean, Integer.MIN_VALUE);
      pacificAtlantic(heights, i, heights[0].length - 1, 
        atlOcean, Integer.MIN_VALUE);
    }

    for (int i = 0; i < heights[0].length; i++) {
      pacificAtlantic(heights, 0, i, 
        pacOcean, Integer.MIN_VALUE);
      pacificAtlantic(heights, heights.length - 1, i, 
        atlOcean, Integer.MIN_VALUE);
    }

    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights[0].length; j++) {
        if (pacOcean[i][j] && atlOcean[i][j]) {
          res.add(List.of(i, j));
        }
      }
    }

    return res;
  }

  public void pacificAtlantic(int[][] heights, int r, int c, boolean[][] ocean, int prevHeight) {
    if (r < 0 || c < 0 || 
        r == heights.length || 
        c == heights[0].length || 
        ocean[r][c] || heights[r][c] < prevHeight) {
          return;
    }

    ocean[r][c] = true;
    
    pacificAtlantic(heights, r + 1, c, ocean, heights[r][c]);
    pacificAtlantic(heights, r - 1, c, ocean, heights[r][c]);
    pacificAtlantic(heights, r, c + 1, ocean, heights[r][c]);
    pacificAtlantic(heights, r, c - 1, ocean, heights[r][c]);
  }
}
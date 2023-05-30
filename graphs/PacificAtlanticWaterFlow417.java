package graphs;

import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class PacificAtlanticWaterFlow417 {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    HashSet<List<Integer>> pacVisited = new HashSet<>();
    HashSet<List<Integer>> atlVisited = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    
    for (int i = 0; i < heights.length; i++) {
      pacificAtlantic(heights, i, 0, 
        pacVisited, Integer.MIN_VALUE);
      pacificAtlantic(heights, i, heights[0].length - 1, 
        atlVisited, Integer.MIN_VALUE);
    }

    for (int i = 0; i < heights[0].length; i++) {
      pacificAtlantic(heights, 0, i, 
        pacVisited, Integer.MIN_VALUE);
      pacificAtlantic(heights, heights.length - 1, i, 
        atlVisited, Integer.MIN_VALUE);
    }

    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights[0].length; j++) {
        List<Integer> cur = List.of(i, j);
        
        if (pacVisited.contains(cur) && 
            atlVisited.contains(cur)) {
              res.add(cur);
        }
      }
    }

    return res;
  }

  public void pacificAtlantic(int[][] heights, int r, int c, HashSet<List<Integer>> visited, int prevHeight) {
    if (r < 0 || c < 0 || 
        r == heights.length || 
        c == heights[0].length || 
        visited.contains(List.of(r, c)) ||
        heights[r][c] < prevHeight) {
          return;
    }

    visited.add(List.of(r, c));
    pacificAtlantic(heights, r + 1, c, visited, heights[r][c]);
    pacificAtlantic(heights, r - 1, c, visited, heights[r][c]);
    pacificAtlantic(heights, r, c + 1, visited, heights[r][c]);
    pacificAtlantic(heights, r, c - 1, visited, heights[r][c]);
  }
}
package backtracking;

import java.util.List;
import java.util.HashSet;

public class WordSearch79 {
  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (exist(board, word, new HashSet<>(), i, j, 0))           return true;
      }
    }

    return false;
  }

  public boolean exist(char[][] board, String word, HashSet<List<Integer>> visited, int r, int c, int i) {
    if (i == word.length()) {
      return true;
    }

    List<Integer> coord = List.of(r, c);

    if (r < 0 || c < 0 || 
        r >= board.length || 
        c >= board[0].length || 
        word.charAt(i) != board[r][c] || 
        visited.contains(coord)) {
          return false;
    }

    visited.add(coord);
    boolean res = 
      exist(board, word, visited, r + 1, c, i + 1) ||
      exist(board, word, visited, r - 1, c, i + 1) ||
      exist(board, word, visited, r, c + 1, i + 1) ||
      exist(board, word, visited, r, c - 1, i + 1);
    visited.remove(coord);
    return res;
  }
}
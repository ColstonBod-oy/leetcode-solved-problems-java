package backtracking;

import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
  
public class NQueens51 {
  List<List<String>> res = new ArrayList<>();
  HashSet<Integer> col = new HashSet<>();
  HashSet<Integer> negDiag = new HashSet<>();
  HashSet<Integer> posDiag = new HashSet<>();
  
  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];

    for (char[] row : board) {
      Arrays.fill(row, '.');
    }

    solveNQueens(board, n, 0);
    return res;
  }

  public void solveNQueens(char[][] board, int n, int r) {
    if (r == n) {
      List<String> valid = new ArrayList<>();
      
      for (char[] row : board) {
        StringBuilder sb = new StringBuilder();
        
        for (char col : row) {
          sb.append(col);
        }

        valid.add(sb.toString());
      }

      res.add(valid);
      return;
    }

    for (int c = 0; c < n; c++) {
      if (col.contains(c) || 
          negDiag.contains(r - c) || 
          posDiag.contains(r + c)) {
            continue;
      }
      
      col.add(c);
      negDiag.add(r - c);
      posDiag.add(r + c);
      board[r][c] = 'Q';
      
      solveNQueens(board, n, r + 1);
      
      col.remove(c);
      negDiag.remove(r - c);
      posDiag.remove(r + c);
      board[r][c] = '.';
    }
  }
}
package graphs;

public class SurroundedRegions130 {
  public void solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == 'O') {
        solve(board, i, 0);        
      }

      if (board[i][board[0].length - 1] == 'O') {
        solve(board, i, board[0].length - 1);        
      }
    }

    for (int i = 0; i < board[0].length; i++) {
      if (board[0][i] == 'O') {
        solve(board, 0, i);        
      }

      if (board[board.length - 1][i] == 'O') {
        solve(board, board.length - 1, i);        
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }

        if (board[i][j] == 'T') {
          board[i][j] = 'O';
        }
      }
    }
  }

  public void solve(char[][] board, int r, int c) {
    if (r < 0 || c < 0 || 
        r == board.length || 
        c == board[0].length || 
        board[r][c] != 'O') {
         return; 
    }

    board[r][c] = 'T';

    solve(board, r + 1, c);
    solve(board, r - 1, c);
    solve(board, r, c + 1);
    solve(board, r, c - 1);
  }
}
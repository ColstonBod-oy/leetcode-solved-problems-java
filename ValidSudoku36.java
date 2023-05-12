import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

class ValidSudoku36 {
  public boolean isValidSudoku(char[][] board) {
    HashSet<Character> set = new HashSet<>();
    HashMap<ArrayList<Integer>, 
      HashSet<Character>> map = new HashMap<>();
      
    for (int i = 0; i < board[0].length; i++) {
      set.clear();
       
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != '.') {
          if (set.contains(board[i][j])) {
            return false;
          }

          set.add(board[i][j]);
          int x = i / 3;
          int y = j / 3;
          ArrayList<Integer> key = new ArrayList<>(Arrays.asList(x, y));
          map.computeIfAbsent(key, k -> new HashSet<>());
          
          if (map.get(key).contains(board[i][j])) {
            return false;
          }

          map.get(key).add(board[i][j]);
        }
      }
    }

    for (int i = 0; i < board[0].length; i++) {
      set.clear();

      for (char[] row : board) {
        if (row[i] != '.') {
          if (set.contains(row[i])) {
            return false;
          }

          set.add(row[i]);
        }
      }
    }

    return true;
  }
}
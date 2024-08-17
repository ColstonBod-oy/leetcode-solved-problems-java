package tries;

import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class WordSearchII212 {
  TrieNode root;
  List<String> res;
  HashSet<String> visited;
  
  public List<String> findWords(char[][] board, String[] words) {
    root = new TrieNode();
    res = new ArrayList<>();
    visited = new HashSet<>();
    
    for (String w : words) {
      root.addWord(w);
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        findWords(board, i, j, root, "");
      }
    }

    return res;
  }

  public void findWords(char[][] board, int r, int c, TrieNode n, String word) {
    if (r < 0 || c < 0 || r == board.length || 
        c == board[0].length || visited.contains(r + "-" + c) || 
        n.refs < 1 || n.children[board[r][c] - 'a'] == null) {
          return;
    }

    visited.add(r + "-" + c);
    n = n.children[board[r][c] - 'a'];
    word += board[r][c];

    if (n.isEndOfWord) {
      n.isEndOfWord = false;
      res.add(word);
      root.removeWord(word);
    }

    findWords(board, r + 1, c, n, word);
    findWords(board, r - 1, c, n, word);
    findWords(board, r, c + 1, n, word);
    findWords(board, r, c - 1, n, word);
    visited.remove(r + "-" + c);
  }

  class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int refs;

    public TrieNode() {
      children = new TrieNode[26];
      isEndOfWord = false;
      refs = 0;
    }

    public void addWord(String word) {
      TrieNode cur = this;
      cur.refs += 1;
      
      for (char c : word.toCharArray()) {
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode();
        }

        cur = cur.children[c - 'a'];
        cur.refs += 1;
      }

      cur.isEndOfWord = true;
    }

    public void removeWord(String word) {
      TrieNode cur = this;
      cur.refs -= 1;
      
      for (char c : word.toCharArray()) {
        if (cur.children[c - 'a'] != null) {
          cur = cur.children[c - 'a'];
          cur.refs -= 1;
        }
      }
    }
  }
}
package graphs;

import java.util.List;
import java.util.Deque;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class WordLadder127 {
  public int ladderLength(String beginWord, 
      String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }

    wordList.add(beginWord);
    
    HashMap<String, List<String>> adj = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    
    for (String word : wordList) {
      for (int i = 0; i < beginWord.length(); i++) {
        String pattern = word.substring(0, i) 
                         + "*" + word.substring(i + 1);
        
        adj.computeIfAbsent(pattern, 
                            k -> new ArrayList<>());
        adj.get(pattern).add(word);
      }
    }

    Deque<String> dq = new ArrayDeque<>();
    dq.offerLast(beginWord);
    visited.add(beginWord);
    int res = 1;

    while (!dq.isEmpty()) {
      for (int i = dq.size(); i > 0; i--) {
        String cur = dq.pollFirst();

        if (cur.equals(endWord)) {
          return res;
        }
        
        for (int j = 0; j < beginWord.length(); j++) {
          String pattern = cur.substring(0, j) 
                           + "*" + cur.substring(j + 1);

          for (String word : adj.get(pattern)) {
            if (!visited.contains(word)) {
              visited.add(word);
              dq.offerLast(word);
            }
          }
        }
      }

      ++res;
    }
    
    return 0;
  }
}
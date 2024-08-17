package advancedgraphs;

import java.util.HashSet;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AlienDictionary892 {
  StringBuilder res = new StringBuilder();
  HashMap<Character, HashSet<Character>> map 
  = new HashMap<>();
  
  /**
   * @param words: a list of words
   * @return: a string which is correct order
   */
  public String alienOrder(String[] words) {
    for (String word : words) {
      for (char c : word.toCharArray()) {
        map.computeIfAbsent(c, k -> new HashSet<>());
      }
    }

    for (int i = 0; i < words.length - 1; i++) {
      String w1 = words[i];
      String w2 = words[i + 1];
      int minLen = Math.min(w1.length(), w2.length());

      if (w1.substring(0, minLen)
            .equals(w2.substring(0, minLen)) 
            && w1.length() > w2.length()) {
        return "";
      }

      for (int j = 0; j < minLen; j++) {
        if (w1.charAt(j) != w2.charAt(j)) {
          map.get(w1.charAt(j)).add(w2.charAt(j));
          break;
        }
      }
    }
    
    int[] indegree = new int[26];

    for (char c : map.keySet()) {
      for (char v : map.get(c)) {
        ++indegree[v - 'a']; 
      }
    }

    PriorityQueue<Character> pq = new PriorityQueue<>();

    for (char c : map.keySet()) {
      if (indegree[c - 'a'] == 0) {
        pq.offer(c);
      }
    }

    while (!pq.isEmpty()) {
      res.append(pq.peek());
      
      for (char c : map.get(pq.poll())) {
        if (--indegree[c - 'a'] == 0) {
          pq.offer(c);
        }
      }
    }

    for (int i : indegree) {
      if (i > 0) {
        return "";
      }
    }

    return res.toString();
  }
}
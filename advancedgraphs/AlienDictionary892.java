package advancedgraphs;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class AlienDictionary892 {
  boolean[] visited = new boolean[26];
  boolean[] finished = new boolean[26];
  StringBuilder res = new StringBuilder();
  LinkedHashMap<Character, HashSet<Character>> map 
  = new LinkedHashMap<>();
  
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
            == w2.substring(0, minLen) 
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

    for (char c : map.keySet()) {
      if (alienOrder(c)) {
        return "";
      }
    }

    res.reverse();
    return res.toString();
  }

  public boolean alienOrder(char c) {
    if (finished[c - 'a'] == true) {
      return false;
    }
    
    if (visited[c - 'a'] == true) {
      return true;
    }

    visited[c - 'a'] = true;

    for (char nei : map.get(c)) {
      if (alienOrder(nei)) {
        return true;
      }
    }

    visited[c - 'a'] = false;
    finished[c - 'a'] = true;
    res.append(c);

    return false;
  }
}
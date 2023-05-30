package slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring76 {
  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }

    if (s.equals(t)) {
      return t;
    }

    int leftPtr = 0;
    int start = 0;
    int have = 0;
    int minLen = s.length() + 1;
    HashMap<Character, Integer> mapT = new HashMap<>();

    for (char c : t.toCharArray()) {
      mapT.put(c, mapT.getOrDefault(c, 0) + 1);
    }

    int need = mapT.size();
    HashMap<Character, Integer> mapWindow = new HashMap<>(mapT);
    mapWindow.replaceAll((key, val) -> 0);

    for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
      char c = s.charAt(rightPtr);

      if (mapWindow.containsKey(c)) {
        mapWindow.put(c, mapWindow.get(c) + 1);

        if (mapWindow.get(c).equals(mapT.get(c))) {
          ++have;
        }
      }

      while (have == need) {
        int len = rightPtr - leftPtr + 1;
        
        if (minLen > len) {
          minLen = len;
          start = leftPtr;
        }
    
        char removed = s.charAt(leftPtr++);

        if (mapWindow.containsKey(removed)) {
          mapWindow.put(removed, mapWindow.get(removed) - 1);
          
          if (mapWindow.get(removed).intValue() < 
              mapT.get(removed).intValue()) {
                --have;
          }
        }
      }
    }

    return minLen > s.length() ? "" : 
           s.substring(start, start + minLen);
  }
}
import java.util.HashMap;

class MinimumWindowSubstring76 {
  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }

    if (s.equals(t)) {
      return t;
    }

    int leftPtr = 0;
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
        mapWindow.compute(c, (key, val) -> ++val);

        if (mapWindow.get(c) == mapT.get(c)) {
          ++have;
        }
      }

      while (have == need) {
        int len = rightPtr - leftPtr;
        
        if (minLen > len) {
          minLen = len;
        }

        char removed = s.charAt(leftPtr++);

        if (mapWindow.containsKey(removed)) {
          mapWindow.compute(c, (key, val) -> --val);
          
          if (mapWindow.get(c) < mapT.get(c)) {
            --have;
          }
        }
      }
    }

    return s.substring(leftPtr, leftPtr + minLen);
  }
}
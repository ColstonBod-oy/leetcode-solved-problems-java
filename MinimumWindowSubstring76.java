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
        int len = rightPtr - leftPtr + 1;
        
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

    // while (rightPtr < s.length() - 1) {
    //   ++rightPtr;

    //   if (mapWindow.containsKey(s.charAt(rightPtr))) {
    //     mapWindow.compute(s.charAt(rightPtr), (key, val) -> ++val);
        
    //     if (mapWindow.get(s.charAt(rightPtr)) == mapT.get(s.charAt(rightPtr))) {
    //       ++have;
    //     }  
    //   }

    //   while (have == need) {  
    //     if (s.substring(leftPtr, rightPtr + 1).length() < len) {
    //       res = s.substring(leftPtr, rightPtr + 1);
    //       len = res.length();
    //     }

    //     if (mapWindow.containsKey(s.charAt(leftPtr))) {
    //       mapWindow.compute(s.charAt(leftPtr), (key, val) -> --val);
          
    //       if (mapWindow.get(s.charAt(leftPtr)) < mapT.get(s.charAt(leftPtr))) {
    //         --have;
    //       }  
    //     }

    //     ++leftPtr; 
    //   }
    // }

    // return res;
    return s.substring(leftPtr - 1, leftPtr - 1 + minLen);
  }
}
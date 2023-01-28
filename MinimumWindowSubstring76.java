import java.util.HashMap;

class MinimumWindowSubstring76 {
  public String minWindow(String s, String t) {
    String res = "";
    
    if (t.length() > s.length()) {
      return res;
    }

    if (s.equals(t)) {
      return t;
    }

    int leftPtr = 0;
    int rightPtr = 0;
    int have = 0;
    int len = s.length();
    HashMap<Character, Integer> mapT = new HashMap<>();

    for (char c : t.toCharArray()) {
      mapT.computeIfAbsent(c, key -> 0);
      mapT.computeIfPresent(c, (key, val) -> ++val);
    }

    int need = mapT.size();
    HashMap<Character, Integer> mapWindow = new HashMap<>(mapT);
    mapWindow.replaceAll((key, val) -> 0);

    if (mapWindow.containsKey(s.charAt(leftPtr))) {
      mapWindow.compute(s.charAt(leftPtr), (key, val) -> ++val);
      ++have;
      
      if (have == need) {
        return Character.toString(s.charAt(leftPtr));
      }
    }

    while (rightPtr < s.length() - 1) {
      ++rightPtr;

      if (mapWindow.containsKey(s.charAt(rightPtr))) {
        mapWindow.compute(s.charAt(rightPtr), (key, val) -> ++val);
        
        if (mapWindow.get(s.charAt(rightPtr)) == mapT.get(s.charAt(rightPtr))) {
          ++have;
        }  
      }

      while (have == need) {
        if (s.substring(leftPtr, rightPtr + 1).length() <= len) {
          res = s.substring(leftPtr, rightPtr + 1);
          len = res.length();
        }

        if (mapWindow.containsKey(s.charAt(leftPtr))) {
          mapWindow.compute(s.charAt(leftPtr), (key, val) -> --val);
          
          if (mapWindow.get(s.charAt(leftPtr)) < mapT.get(s.charAt(leftPtr))) {
            --have;
          }  
        }

        ++leftPtr; 
      }
    }

    return res;
  }
}
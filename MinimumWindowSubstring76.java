import java.util.HashMap;

class MinimumWindowSubstring76 {
  public String minWindow(String s, String t) {
    String res = "";
    
    if (t.length() > s.length()) {
      return res;
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

    if (mapWindow.containsKey(s.charAt(0))) {
      mapWindow.compute(s.charAt(0), (key, val) -> ++val);
      ++have;
    }

    while (rightPtr < s.length() - 1) {
      ++rightPtr;
    
      mapWindow.computeIfPresent(s.charAt(rightPtr), (key, val) -> ++val);

      if (mapWindow.containsKey(s.charAt(rightPtr))) {
        if (mapWindow.get(s.charAt(rightPtr)) >= mapT.get(s.charAt(rightPtr))) {
          ++have;
        }  
      }

      while (have == need) {
        if (s.substring(leftPtr, rightPtr + 1).length() < len) {
          res = s.substring(leftPtr, rightPtr + 1);
          len = res.length();
          System.out.println(res);
        }
    
        mapWindow.computeIfPresent(s.charAt(leftPtr), (key, val) -> --val);

        if (mapWindow.containsKey(s.charAt(leftPtr))) {
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
package twoddynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class RegularExpressionMatching10 {
  HashMap<List<Integer>, Boolean> dp = new HashMap<>();
  
  public boolean isMatch(String s, String p, 
                         int i, int j) {
    List<Integer> cur = List.of(i, j);
    
    if (dp.containsKey(cur)) {
      return dp.get(cur);
    }
    
    if (i == s.length() && j >= p.length()) {
      return true;
    }

    if (j >= p.length()) {
      return false;
    }

    boolean isMatched = (i < s.length()) 
                        && (s.charAt(i) == p.charAt(j) 
                            || p.charAt(j) == '.');

    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
      dp.put(cur, isMatch(s, p, i, j + 2) 
             || (isMatched && isMatch(s, p, i + 1, j)));
      
      return dp.get(cur);
    }

    if (isMatched) {
      dp.put(cur, isMatch(s, p, i + 1, j + 1));
      
      return dp.get(cur);
    }

    dp.put(cur, false);

    return false;
  }
  
  public boolean isMatch(String s, String p) {
    return isMatch(s, p, 0, 0);
  }
}
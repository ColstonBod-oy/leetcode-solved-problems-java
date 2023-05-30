package backtracking;

import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning131 {
  List<List<String>> res = new ArrayList<>();
  List<String> part = new ArrayList<>();
  
  public List<List<String>> partition(String s) {
    partition(s, 0);
    return res;
  }

  public void partition(String s, int i) {
    if (i == s.length()) {
      res.add(new ArrayList<>(part));
      return;
    }

    for (int j = i; j < s.length(); j++) {
      if (isPalindrome(s, i, j)) {
        part.add(s.substring(i, j + 1));
        partition(s, j + 1);
        part.remove(part.size() - 1);
      }
    }
  }

  public boolean isPalindrome(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) return false;
      l += 1;
      r -= 1;
    }

    return true;
  }
}
package backtracking;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber17 {
  List<String> res = new ArrayList<>();
  HashMap<Character, String> map = new HashMap<>() {
    {
      put('2', "abc");
      put('3', "def");
      put('4', "ghi");
      put('5', "jkl");
      put('6', "mno");
      put('7', "pqrs");
      put('8', "tuv");
      put('9', "wxyz");
    }
  };
  
  public List<String> letterCombinations(String digits) {
    if (digits.length() > 0) {
      letterCombinations(digits, 0, "");
    }

    return res;
  }

  public void letterCombinations(String digits, int i, String s) {
    if (i == digits.length()) {
      res.add(s);
      return;
    }

    for (char c : map.get(digits
         .charAt(i)).toCharArray()) {
          letterCombinations(digits, i + 1, s + c);
    }
  }
}
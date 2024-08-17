package oneddynamicprogramming;

public class LongestPalindromicSubstring5 {
  public String longestPalindrome(String s, 
      String res, int resLen, int start, int end) {
    while (start >= 0 && end < s.length() 
           && s.charAt(start) == s.charAt(end)) {
      if (end - start + 1 > resLen) {
        res = s.substring(start, end + 1);
        resLen = end - start + 1;
      }

      --start;
      ++end;
    }

    return res;
  }
  
  public String longestPalindrome(String s) {
    String res = "";

    for (int i = 0; i < s.length(); i++) {
      int resLen = res.length();
      res = longestPalindrome(s, res, resLen, i, i);
      
      resLen = res.length();
      res = longestPalindrome(s, res, resLen, i, i + 1);
    }

    return res;
  }
}
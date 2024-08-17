package arrayshashing;

import java.util.List;
import java.util.ArrayList;

public class EncodeAndDecodeStrings659 {
  /*
   * @param strs: a list of strings
   * @return: encodes a list of strings to a single string.
   */
  public String encode(List<String> strs) {
    String res = "";
      
    for (String str : strs) {
      res += str.length() + "#" + str;
    }

    return res;
  }

  /*
   * @param str: A string
   * @return: dcodes a single string to a list of strings
   */
  public List<String> decode(String str) {
    ArrayList<String> strs = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {
      String res = "";
        
      while (str.charAt(i) != '#') {
        res += str.charAt(i);
        ++i;
      }

      int num = Integer.parseInt(res);
      res = "";

      while (num > 0) {
        res += str.charAt(++i);
        --num;
      }

      strs.add(res);
      ++i;
    }

    return strs;
  }
}
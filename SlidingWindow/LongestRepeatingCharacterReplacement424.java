import java.util.HashMap;

class LongestRepeatingCharacterReplacement424 {
  public int characterReplacement(String s, int k) {
    int res = 0;
    int maxFrequency = 0;
    int leftPtr = 0;
    HashMap<Character, Integer> map = new HashMap<>();

    for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
      int windowSize = rightPtr - leftPtr + 1;
      Character rightChar = s.charAt(rightPtr);
      
      map.computeIfAbsent(rightChar, key -> 0);
      map.computeIfPresent(rightChar, (key, val) -> ++val);

      if (map.get(rightChar) > maxFrequency) {  
        maxFrequency = map.get(rightChar);
      }

      if (windowSize - maxFrequency <= k) {
        if (windowSize > res) {
          res = windowSize;
        }
      }

      else {
        while (!(windowSize - maxFrequency <= k)) {
          map.compute(s.charAt(leftPtr), (key, val) -> --val);
          ++leftPtr;

          windowSize = rightPtr - leftPtr + 1;
        }
      }
    }

    return res;
  }
}
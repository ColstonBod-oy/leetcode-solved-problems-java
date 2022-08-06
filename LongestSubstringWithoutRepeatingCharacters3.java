import java.util.HashSet;

class LongestSubstringWithoutRepeatingCharacters3 {
  public int lengthOfLongestSubstring(String s) {
    int res = 0;
    int counter = 0;
    int leftPtr = 0;
    int rightPtr = 0;
    HashSet<Character> set = new HashSet<>();

    while (rightPtr < s.length()) {
      if (set.add(Character.valueOf(s.charAt(rightPtr)))) {
        ++counter;
      }

      else {
        while (s.charAt(leftPtr) != s.charAt(rightPtr)) {
          set.remove(Character.valueOf(s.charAt(leftPtr)));
          ++leftPtr;
          --counter;
        }

        ++leftPtr;
      }

      if (counter > res) {
        res = counter;
      }

      ++rightPtr;
    }

    return res;
  }
}
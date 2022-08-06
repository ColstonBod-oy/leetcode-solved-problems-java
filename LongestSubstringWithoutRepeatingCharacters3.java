import java.util.HashSet;

class LongestSubstringWithoutRepeatingCharacters3 {
  public int lengthOfLongestSubstring(String s) {
    int res = 0;
    int counter = 0;
    int leftPtr = 0;
    int rightPtr = 0;
    HashSet<Character> set = new HashSet<>();

    while (rightPtr < s.length()) {
      char leftChar = s.charAt(leftPtr);
      char rightChar = s.charAt(rightPtr);
      
      if (set.add(Character.valueOf(rightChar))) {
        ++counter;

        if (counter > res) {
          res = counter;
        }
      }

      else {
        while (leftChar != rightChar) {
          set.remove(Character.valueOf(leftChar));
          ++leftPtr;
          --counter;

          leftChar = s.charAt(leftPtr);
        }

        ++leftPtr;
      }

      ++rightPtr;
    }

    return res;
  }
}
import java.util.HashMap;

class PermutationInString567 {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    int leftPtr = 0;
    int rightPtr = s1.length() - 1;
    int matches = 0;
    
    HashMap<Character, Integer> mapS1 = new HashMap<>() {
      {
        for (char c = 'a'; c <= 'z'; c++) {
          put(Character.valueOf(c), 0);
        }
      }
    };
    
    HashMap<Character, Integer> mapS2 = new HashMap<>(mapS1);

    for (int i = 0; i <= rightPtr; i++) {
      mapS1.compute(Character.valueOf(s1.charAt(i)), (key, val) -> ++val);
      mapS2.compute(Character.valueOf(s2.charAt(i)), (key, val) -> ++val);
    }

    for (char c = 'a'; c <= 'z'; c++) {
      if (mapS1.get(Character.valueOf(c)) == mapS2.get(Character.valueOf(c))) {
        ++matches;
      }
    }

    if (matches == 26) {
      return true;
    }
    
    while (rightPtr < s2.length() - 1) {
      mapS2.compute(Character.valueOf(s2.charAt(leftPtr)), (key, val) -> --val);

      if (mapS2.get(Character.valueOf(s2.charAt(leftPtr))) + 1 == mapS1.get(Character.valueOf(s2.charAt(leftPtr)))) {
        --matches;
      }

      else if (mapS2.get(Character.valueOf(s2.charAt(leftPtr))) == mapS1.get(Character.valueOf(s2.charAt(leftPtr)))) {
        ++matches;
      }
      
      ++leftPtr;
      ++rightPtr;
      mapS2.compute(Character.valueOf(s2.charAt(rightPtr)), (key, val) -> ++val);

      if (mapS2.get(Character.valueOf(s2.charAt(rightPtr))) - 1 == mapS1.get(Character.valueOf(s2.charAt(rightPtr)))) {
        --matches;
      }

      else if (mapS2.get(Character.valueOf(s2.charAt(rightPtr))) == mapS1.get(Character.valueOf(s2.charAt(rightPtr)))) {
        ++matches;
      }
      
      if (matches == 26) {
        return true;
      }
    }

    return false;
  }
}
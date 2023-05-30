package arrayshashing;

import java.util.Arrays;

public class RansomNote383 {
  char[] ransomArray;
  char[] magazineArray;
  int counter;
    
  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote.length() > magazine.length()) {
      return false;
    }
      
    ransomArray = ransomNote.toCharArray();
    magazineArray = magazine.toCharArray();
    Arrays.sort(ransomArray);
    Arrays.sort(magazineArray);
      
    for (int i = 0; i < ransomArray.length; i++) {
      if (counter == magazineArray.length - 1 &&
          ransomArray[i] != magazineArray[counter]) {
            return false;
      }

      if (counter == magazineArray.length - 1 && 
          i != ransomArray.length - 1) {
            return false;
      }

      while (ransomArray[i] != magazineArray[counter]) {
        counter++;

        if (counter == magazineArray.length) {
          return false;
        }
      }

      counter++;
    }

    return true;
  }
}
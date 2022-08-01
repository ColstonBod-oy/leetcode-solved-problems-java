class ValidPalindrome125 {
  public boolean isPalindrome(String s) {
    int leftPtr = 0;
    int rightPtr = s.length() - 1;

    while (leftPtr < rightPtr) {
      while (!isAlphanumeric(s.charAt(leftPtr)) && leftPtr < rightPtr) {
        ++leftPtr;
      }

      while (!isAlphanumeric(s.charAt(rightPtr)) && rightPtr > leftPtr) {
        --rightPtr;
      }

      if (Character.toLowerCase(s.charAt(leftPtr)) != Character.toLowerCase(s.charAt(rightPtr))) {
        return false;
      }

      ++leftPtr;
      --rightPtr;
    }

    return true;
  }

  private boolean isAlphanumeric(char c) {
    return (c >= 'a' && c <= 'z') ||
           (c >= 'A' && c <= 'Z') ||
           (c >= '0' && c <= '9');
  }
}
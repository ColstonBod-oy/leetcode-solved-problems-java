package stack;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {
  public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }
    
    Stack<Character> charStack = new Stack<>();
    Map<Character, Character> charMap = Map
      .of(')', '(', '}', '{', ']', '[');

    for (char c : s.toCharArray()) {
      if (charMap.containsKey(c)) {
        if (!charStack.isEmpty() && charStack.peek()
            .equals(charMap.get(c))) {
              charStack.pop();  
        }

        else {
          return false;
        }
      }

      else {
        charStack.push(c);
      }
    }

    return charStack.isEmpty();
  }
}
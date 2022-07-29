import java.util.Stack;

class RomanToInteger13 {
  private int previous;
  private int oldPrevious;
  private int current;
  private int result;
  
  public int romanToInt(String s) { 
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'I':
          stack.push(1);
          break;
        case 'V':
          stack.push(5);
          break;
        case 'X':
          stack.push(10);
          break;
        case 'L':
          stack.push(50);
          break;
        case 'C':
          stack.push(100);
          break;
        case 'D':
          stack.push(500);
          break;
        case 'M':
          stack.push(1000);
          break;
      }
    }

    while (!stack.isEmpty() && stack.size() > 1) {
      current = stack.pop();
      previous = stack.pop();

      if (current < oldPrevious) {
        result += previous - current; 
        oldPrevious = previous;
      }
      
      else if (previous < current) {
        result += current - previous;
        oldPrevious = previous;
      }

      else {
        result += current + previous; 
        oldPrevious = previous;
      }
    }

    if (stack.size() == 1) {
      current = stack.pop();

      if (current >= oldPrevious) {
        result += current;
      } 

      else if (current < oldPrevious) {
        result -= current;
      }
    }
    
    return result;
  }
}
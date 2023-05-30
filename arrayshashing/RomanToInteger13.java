package arrayshashing;

import java.util.Queue;
import java.util.LinkedList;

public class RomanToInteger13 {
  int previous;
  int current;
  int result;
  
  public int romanToInt(String s) { 
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'I':
          queue.add(1);
          break;
        case 'V':
          queue.add(5);
          break;
        case 'X':
          queue.add(10);
          break;
        case 'L':
          queue.add(50);
          break;
        case 'C':
          queue.add(100);
          break;
        case 'D':
          queue.add(500);
          break;
        case 'M':
          queue.add(1000);
          break;
      }
    }

    if (queue.size() == 2) {
      previous = queue.poll();
      current = queue.poll();

      if (previous < current) {
        result += current - previous; 
      }
      
      else {
        result += current + previous; 
      }
    }

    while (!queue.isEmpty() && queue.size() > 1) {
      if (previous == 0) {
        previous = queue.poll();
        current = queue.poll();
      }

      else {
        current = queue.poll();
      }

      if (previous < current) {
        result -= previous; 
        previous = current;
      }
      
      else {
        result += previous; 
        previous = current;
      }
    }

    if (queue.size() == 1) {
      current = queue.poll();

      if (previous < current) {
        result += current - previous; 
      }
      
      else {
        result += current + previous; 
      }
    }
    
    return result;
  }
}
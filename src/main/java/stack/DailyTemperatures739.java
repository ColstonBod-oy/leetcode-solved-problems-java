package stack;

import java.util.Stack;

public class DailyTemperatures739 {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> s = new Stack<>();
    int[] res = new int[temperatures.length];
    
    for (int i = 0; i < temperatures.length; i++) {
      while (!s.empty() && temperatures[i] >     
             temperatures[s.peek()]) {
                int j = s.pop();
                res[j] = i - j;
      }

      s.push(i);
    }

    return res;
  }
}
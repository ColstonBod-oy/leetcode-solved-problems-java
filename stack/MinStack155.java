package stack;

import java.util.Stack;

public class MinStack155 {
  Stack<Integer> s = new Stack<>();
  Stack<Integer> minS = new Stack<>();
  
  public void push(int val) {
    s.push(val);

    if (!minS.isEmpty()) {
      val = Math.min(val, minS.peek());
    }
    
    minS.push(val);
  }
    
  public void pop() {
    s.pop();
    minS.pop();
  }
    
  public int top() {
    return s.peek();
  }
    
  public int getMin() {
    return minS.peek();
  }
}
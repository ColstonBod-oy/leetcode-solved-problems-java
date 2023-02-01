import java.util.Stack;

class MinStack155 {
  private Stack<Integer> s;
  private Stack<Integer> minS;

  public MinStack155() {
    s = new Stack<>();
    minS = new Stack<>();
  }
    
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
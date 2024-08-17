package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {
  public int evalRPN(String[] tokens) {
    Stack<Integer> s = new Stack<>();
    Integer a = null, b = null;

    for (String t : tokens) {
      switch (t) {
        case "+":
          s.push(s.pop() + s.pop());
          break;
        case "-":
          a = s.pop(); 
          b = s.pop();
          s.push(b - a);
          break;
        case "*":
          s.push(s.pop() * s.pop());
          break;
        case "/":
          a = s.pop();
          b = s.pop();
          s.push(b / a);
          break;
        default:
          s.push(Integer.valueOf(t));
      }
    }

    return s.peek();
  }
}
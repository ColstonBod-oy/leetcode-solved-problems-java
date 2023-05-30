package stack;

import java.util.Stack;

public class LargestRectangleInHistogram84 {
  public int largestRectangleArea(int[] heights) {
    int start;
    int maxArea = 0;
    int len = heights.length;
    Stack<Pair<Integer, Integer>> stack = new Stack<>();

    for (int i = 0; i < len; i++) {
      start = i;
      
      while (!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
        Pair<Integer, Integer> pair = stack.pop();
        int key = pair.getKey();
        int value = pair.getValue();
        maxArea = Math.max(maxArea, value * (i - key));
        start = key;
      }

      stack.push(new Pair(start, heights[i]));
    }

    while (!stack.isEmpty()) {
      Pair<Integer, Integer> pair = stack.pop();
      int key = pair.getKey();
      int value = pair.getValue();
      maxArea = Math.max(maxArea, value * (len - key));
    }

    return maxArea;
  }

  class Pair<T, V> {
    T key;
    V value;

    public Pair(T key, V value) {
      this.key = key;
      this.value = value;
    }

    public T getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }
  }
}
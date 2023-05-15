import java.util.Comparator;
import java.util.PriorityQueue;

class FindMedianFromDataStream295 {
  PriorityQueue<Integer> leftHalf;
  PriorityQueue<Integer> rightHalf;
  
  public FindMedianFromDataStream295() {
    leftHalf = new PriorityQueue<>(Comparator.reverseOrder());
    rightHalf = new PriorityQueue<>();
  }
    
  public void addNum(int num) {
    leftHalf.offer(num);

    if (leftHalf.size() > rightHalf.size() + 1 || 
        !rightHalf.isEmpty() && leftHalf.peek() > 
        rightHalf.peek()) {
          rightHalf.offer(leftHalf.poll());
    }

    if (rightHalf.size() > leftHalf.size() + 1) {
      leftHalf.offer(rightHalf.poll());
    }
  }
    
  public double findMedian() {
    if (leftHalf.size() > rightHalf.size()) {
      return leftHalf.peek();
    }

    if (rightHalf.size() > leftHalf.size()) {
      return rightHalf.peek();
    }

    return (double) (leftHalf.peek() + rightHalf.peek()) / 2;
  }
}
import java.util.Deque;
import java.util.ArrayDeque;

class SlidingWindowMaximum239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    int[] output = new int[nums.length - k + 1];
    int leftPtr = 0;
    int i = 0;    

    for (int rightPtr = 0; rightPtr < nums.length; rightPtr++) {
      while (!deque.isEmpty() && nums[deque.getFirst()] < nums[rightPtr]) {
        deque.removeFirst();
      }

      deque.addFirst(rightPtr);

      if (leftPtr > deque.getLast()) {
        deque.removeLast();
      }

      if (rightPtr + 1 >= k) {
        output[i] = nums[deque.getLast()];
        ++leftPtr;
        ++i;
      }
    }

    return output;
  }
}
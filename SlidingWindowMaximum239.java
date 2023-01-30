import java.util.Deque;
import java.util.ArrayDeque;

class SlidingWindowMaximum239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    int[] output = new int[nums.length - k + 1];
    int leftPtr = 0;
    int rightPtr = 0;    

    for (int i = 0; rightPtr < nums.length; i++) {
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
      }

      ++rightPtr;
    }

    return output;
  }
}
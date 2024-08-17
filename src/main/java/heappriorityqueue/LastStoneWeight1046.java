package heappriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    
    for (int n : stones) {
      pq.offer(n);
    }

    while (pq.size() > 1) {
      int first = pq.poll();
      int second = pq.poll();
      
      if (second < first) {
        pq.offer(first - second);
      }
    }

    return pq.isEmpty() ? 0 : pq.poll();
  }
}
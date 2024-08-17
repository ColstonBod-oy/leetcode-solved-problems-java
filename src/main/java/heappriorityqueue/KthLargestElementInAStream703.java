package heappriorityqueue;

import java.util.PriorityQueue;

public class KthLargestElementInAStream703 {
  PriorityQueue<Integer> pq;
  int k;
  
  public KthLargestElementInAStream703(int k, int[] nums) {
    pq = new PriorityQueue<>();
    this.k = k;
    
    for (int n : nums) {
      pq.offer(n);
    }
    
    while (pq.size() > k) {
      pq.poll();
    }
  }
    
  public int add(int val) {
    pq.offer(val);

    if (pq.size() > k) {
      pq.poll();
    }

    return pq.peek();
  }
}
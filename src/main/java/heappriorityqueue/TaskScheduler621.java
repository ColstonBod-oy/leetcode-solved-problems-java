package heappriorityqueue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskScheduler621 {
  public int leastInterval(char[] tasks, int n) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(
      Comparator.reverseOrder()
    );
    
    Queue<int[]> q = new LinkedList<>();
    int[] arr = new int[26];
    int time = 0;
    
    for (char c : tasks) {
      arr[c - 'A'] += 1;
    }

    for (int val : arr) {
      if (val > 0) {
        pq.offer(val);
      }
    }

    while (!pq.isEmpty() || !q.isEmpty()) {
      ++time;
      
      if (!pq.isEmpty()) {
        int count = pq.poll() - 1;

        if (count > 0) {
          int[] pair = {count, time + n};
          q.offer(pair);
        }
      }

      if (!q.isEmpty() && q.peek()[1] == time) {
        pq.offer(q.poll()[0]);
      }
    }

    return time;
  }
}
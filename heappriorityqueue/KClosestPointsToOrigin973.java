package heappriorityqueue;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin973 {
  public int[][] kClosest(int[][] points, int k) { 
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
      Double.compare(
        Math.pow(b[0], 2) + Math.pow(b[1], 2),
        Math.pow(a[0], 2) + Math.pow(a[1], 2)
      )
    );

    for (int[] point : points) {
      pq.offer(point);

      if (pq.size() > k) {
        pq.poll();
      }
    }

    int[][] res = new int[k][2]; 

    for (int i = 0; i < k; i++) {
      int[] cur = pq.poll();
      res[i][0] = cur[0];
      res[i][1] = cur[1];
    }

    return res;
  }
}
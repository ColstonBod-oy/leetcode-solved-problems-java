package advancedgraphs;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints1584 {
  public int minCostConnectPoints(int[][] points) {
    int n = points.length;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) 
        -> Integer.compare(a[0], b[0]));
    
    pq.offer(new int[] {0, 0});

    HashSet<Integer> visited = new HashSet<>();
    int res = 0;

    while (visited.size() < n) {
      int[] point = pq.poll();

      if (visited.contains(point[1])) {
        continue;
      }

      visited.add(point[1]);
      res += point[0];

      for (int i = 1; i < n; i++) {
        if (!visited.contains(i)) {
          pq.offer(new int[] {Math.abs(points[i][0] 
              - points[point[1]][0]) 
              + Math.abs(points[i][1] 
                         - points[point[1]][1]), 
              i});
        }
      }
    }

    return res;
  }
}
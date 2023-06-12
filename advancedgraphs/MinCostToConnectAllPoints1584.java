package advancedgraphs;

import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints1584 {
  public int minCostConnectPoints(int[][] points) {
    List<List<int[]>> adj = new ArrayList<>();
    int n = points.length;

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int[] point1 = points[i];
        int[] point2 = points[j];
        int dist = Math.abs(point1[0] - point2[0]) 
                   + Math.abs(point1[1] - point2[1]); 
        
        adj.get(i).add(new int[] {dist, j});
        adj.get(j).add(new int[] {dist, i});
      }
    }

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

      for (int[] nei : adj.get(point[1])) {
        if (!visited.contains(nei[1])) {
          pq.offer(nei);
        }
      }
    }

    return res;
  }
}
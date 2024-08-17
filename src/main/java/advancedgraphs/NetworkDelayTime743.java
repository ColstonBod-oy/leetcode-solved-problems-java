package advancedgraphs;

import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelayTime743 {
  public int networkDelayTime(int[][] times, 
                              int n, int k) {
    List<List<int[]>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] time : times) {
      adj.get(time[0] - 1)
         .add(Arrays.copyOfRange(time, 1, 3));
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) 
        -> Integer.compare(a[1], b[1]));
    
    pq.add(new int[] {k, 0});

    HashSet<Integer> visited = new HashSet<>();
    int res = 0;

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();

      if (visited.contains(cur[0])) {
        continue;
      }

      visited.add(cur[0]);
      res = Math.max(res, cur[1]);

      for (int[] nei : adj.get(cur[0] - 1)) {
        if (!visited.contains(nei[0])) {
          pq.offer(new int[] {nei[0], cur[1] + nei[1]});
        }
      }
    }

    return (visited.size() == n) ? res : -1;
  }
}
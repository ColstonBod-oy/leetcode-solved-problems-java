package advancedgraphs;

import java.util.List;
import java.util.Deque;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class CheapestFlightsWithinKStops787 {
  public int findCheapestPrice(int n, int[][] flights, 
                               int src, int dst, int k) {
    List<List<int[]>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] flight : flights) {
      adj.get(flight[0])
         .add(Arrays.copyOfRange(flight, 1, 3));
    }

    Deque<int[]> dq = new ArrayDeque<>();
    dq.offerLast(new int[] {src, 0});

    boolean[] visited = new boolean[n];
    int levels = k + 1;
    int res = Integer.MAX_VALUE;
    
    while (!dq.isEmpty()) {
      for (int i = dq.size(); i > 0; i--) {
        int[] cur = dq.pollFirst();

        if (visited[cur[0]]) {
          continue;
        }

        visited[cur[0]] = true;

        for (int[] nei : adj.get(cur[0])) {
          if (!visited[nei[0]]) {
            if (nei[0] != dst) {
              dq.offerLast(new int[] {nei[0], 
                                      cur[1] + nei[1]});
              continue;
            }

            res = Math.min(res, cur[1] + nei[1]);
          }
        }

        visited[cur[0]] = false;
      }

      if (--levels == 0) {
        break;
      }
    }

    return (res == Integer.MAX_VALUE) ? -1 : res;
  }
}
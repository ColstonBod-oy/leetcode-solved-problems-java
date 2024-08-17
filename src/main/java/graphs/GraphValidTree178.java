package graphs;

import java.util.List;
import java.util.Deque;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class GraphValidTree178 {
  /**
   * @param n: An integer
   * @param edges: a list of undirected edges
   * @return: true if it's a valid tree, or false
   */
  public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) {
      return false;
    }

    List<List<Integer>> adjList = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();
    int[] visited = new int[n];

    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
    }

    dq.offerLast(0);
    visited[0] = 1;
    
    int i = 1;

    while (!dq.isEmpty()) {
      for (int v : adjList.get(dq.pollFirst())) {
        if (visited[v] == 0) {
          dq.offerLast(v);
          visited[v] = 1;
          ++i;
        }
      }
    }

    if (i != n) {
      return false;
    }

    return true;
  }
}
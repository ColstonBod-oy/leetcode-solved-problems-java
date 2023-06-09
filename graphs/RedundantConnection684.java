package graphs;

public class RedundantConnection684 {
  public int findParent(int n, int[] parent) {
    int cur = parent[n - 1];

    while (cur != parent[cur]) {
      parent[cur] = parent[parent[cur]];
      cur = parent[cur];
    }

    return cur;
  }

  public boolean unionNodes(int n1, int n2,
      int[] parent, int[] rank) {
    int parent1 = findParent(n1, parent);
    int parent2 = findParent(n2, parent);

    if (parent1 == parent2) {
      return false;
    }

    if (parent1 > parent2) {
      parent[parent2] = parent1;
      rank[parent1] += rank[parent2];
    } else {
      parent[parent1] = parent2;
      rank[parent2] += rank[parent1];
    }

    return true;
  }
  
  public int[] findRedundantConnection(int[][] edges) {
    int[] parents = new int[edges.length];
    int[] ranks = new int[edges.length];

    for (int i = 0; i < edges.length; i++) {
      parents[i] = i;
      ranks[i] = 1;
    }

    for (int[] edge : edges) {
      if (!unionNodes(edge[0], edge[1], 
                      parents, ranks)) {
        return edge;
      }
    }

    return new int[0];
  }
}
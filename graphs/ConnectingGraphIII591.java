package graphs;

public class ConnectingGraphIII591 {
  int[] parents;
  int[] ranks;
  int connected;
  
  /**
   * @param a: An integer
   * @param b: An integer
   * @return: nothing
   */
  public ConnectingGraphIII591(int n) {
    parents = new int[n];
    ranks = new int[n];
    connected = n;
    
    for (int i = 0; i < n; i++) {
      parents[i] = i;
      ranks[i] = 1;
    }
  }

  public int findParent(int n) {
    int cur = parents[n - 1];

    while (cur != parents[cur]) {
      parents[cur] = parents[parents[cur]];
      cur = parents[cur];
    }

    return cur;
  }
    
  public void connect(int a, int b) {
    int parent1 = findParent(a);
    int parent2 = findParent(b);

    if (parent1 == parent2) {
      return;
    }

    if (ranks[parent1] > ranks[parent2]) {
      parents[parent2] = parent1;
      ranks[parent1] += ranks[parent2];
    } else {
      parents[parent1] = parent2;
      ranks[parent2] += ranks[parent1];
    }

    --connected;
  }

  /**
   * @return: An integer
   */
  public int query() {
    return connected;
  }
}
package graphs;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class CloneGraph133 {
  HashMap<Node, Node> map = new HashMap<>();
  
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    
    if (map.containsKey(node)) {
      return map.get(node);
    }

    Node copy = new Node(node.val);
    map.put(node, copy);

    for (Node n : node.neighbors) {
      copy.neighbors.add(cloneGraph(n));
    }

    return copy;
  }

  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
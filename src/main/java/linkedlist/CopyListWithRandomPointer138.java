package linkedlist;

import java.util.HashMap;

public class CopyListWithRandomPointer138 {
  public Node copyRandomList(Node head) {
    HashMap<Node, Node> map = new HashMap<>();
    Node curNode = head;
    
    while (curNode != null) {
      Node copyNode = new Node(curNode.val);
      map.put(curNode, copyNode);
      curNode = curNode.next;
    }

    curNode = head;
    
    while (curNode != null) {
      Node copyNode = map.get(curNode);
      copyNode.next = map.get(curNode.next);
      copyNode.random = map.get(curNode.random);
      curNode = curNode.next;
    }

    return map.get(head);
  }

  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }

    @Override
    public String toString() {
      String result = val + " -> ";
      
      if (next != null) {
        result += next.toString();
      }
      
      return result;
    }
  }
}
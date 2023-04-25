import java.util.PriorityQueue;

class MergeKSortedLists23 {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.compareTo(b));

    for (ListNode n : lists) {
      if (n != null) {
        queue.offer(n);  
      } 
    }

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    
    while (!queue.isEmpty()) {
      ListNode n = queue.poll();
      curr.next = n;
      curr = curr.next;

      if (n.next != null) {
        queue.offer(n.next);
      }
    }

    return dummy.next;
  }

  class ListNode implements Comparable<ListNode> {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public int compareTo(ListNode n) {
      if (this.val < n.val) {
        return -1;
      }
                             
      else if (this.val > n.val) {
        return 1;
      }
  
      else {
        return 0;
      }
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
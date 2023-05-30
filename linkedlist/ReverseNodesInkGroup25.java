class ReverseNodesInkGroup25 {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);
    ListNode groupPrev = dummy;
    ListNode kth = null;

    while (true) {
      kth = getKth(groupPrev, k);

      if (kth == null) {
        break;
      }

      ListNode groupNext = kth.next;
      ListNode prev = groupNext;
      ListNode curr = groupPrev.next;
      ListNode nextCurr = null;

      while (curr != groupNext) {
        nextCurr = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextCurr;
      }

      ListNode tmp = groupPrev.next;
      groupPrev.next = kth;
      groupPrev = tmp;
    }

    return dummy.next;
  }

  private ListNode getKth(ListNode n, int k) {
    ListNode curr = n;
    
    while (curr != null && k > 0) {
      curr = curr.next;
      --k;
    }

    return curr;
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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
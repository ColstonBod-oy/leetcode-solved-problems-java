class RemoveNthNodeFromEndOfList19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || head.next == null) return null;
    
    ListNode dummy = new ListNode(0, head);
    ListNode l = dummy;
    ListNode r = head;

    while (r != null && n > 0) {
      r = r.next;
      n -= 1;
    }

    while (r != null) {
      l = l.next;
      r = r.next;
    }

    l.next = l.next.next;
    return dummy.next;
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
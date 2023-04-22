class ReverseLinkedList206 {
  private ListNode current;
  private ListNode previous;
  private ListNode nextCurrent;
  
  public ListNode reverseList(ListNode head) {
    current = head;
    previous = null;
    
    while (current != null) {
      nextCurrent = current.next;
      current.next = previous;
      previous = current;
      current = nextCurrent;
    }

    return previous;
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
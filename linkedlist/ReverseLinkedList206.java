package linkedlist;

public class ReverseLinkedList206 {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    
    ListNode newHead = head;

    if (head.next != null) {
      newHead = reverseList(head.next);
      head.next.next = head;
    }

    head.next = null;
    return newHead;
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
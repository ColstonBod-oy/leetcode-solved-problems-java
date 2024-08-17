package linkedlist;

public class ReorderList143 {
  public void reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode current = slow.next;
    slow.next = null;
    ListNode previous = null;
    ListNode nextCurrent = null;

    while (current != null) {
      nextCurrent = current.next;
      current.next = previous;
      previous = current;
      current = nextCurrent;
    }

    ListNode firstHalf = head;
    ListNode secondHalf = previous;

    while (secondHalf != null) {
      ListNode tmp1 = firstHalf.next;
      ListNode tmp2 = secondHalf.next;
      firstHalf.next = secondHalf;
      secondHalf.next = tmp1;
      firstHalf = tmp1;
      secondHalf = tmp2;
    }
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
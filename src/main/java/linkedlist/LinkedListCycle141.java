package linkedlist;

public class LinkedListCycle141 {
  public boolean hasCycle(ListNode head) {
    ListNode tortoise = head;
    ListNode hare = head;

    while (hare != null && hare.next != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;

      if (tortoise == hare) {
        return true;
      }
    }

    return false;
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
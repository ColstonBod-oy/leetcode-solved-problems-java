package linkedlist;

public class MergeKSortedLists23 {
  public ListNode mergeKLists(ListNode[] lists) {
    int size = lists.length;
    int interval = 1;

    while (interval < size) {
      for (int i = 0; i < size - interval; i += 2 * interval) {
        lists[i] = mergeKLists(lists[i], lists[i + interval]);
      }

      interval *= 2;
    }

    return size > 0 ? lists[0] : null;
  }

  public ListNode mergeKLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        curr.next = l1;
        l1 = l1.next;
      }

      else {
        curr.next = l2;
        l2 = l2.next;
      }

      curr = curr.next;
    }

    if (l1 != null) {
      curr.next = l1;
    }

    else {
      curr.next = l2;
    }

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
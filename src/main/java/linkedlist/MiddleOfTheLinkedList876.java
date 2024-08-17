package linkedlist;

public class MiddleOfTheLinkedList876 {
  ListNode current;
  int size;
  int midpoint;
    
  public ListNode middleNode(ListNode head) {
    current = head;

    while (current != null) {
      current = current.next;
      size++;
    }

    midpoint = size / 2 + 1; 
    current = head;

    while (midpoint > 1) {
      current = current.next;
      midpoint--;
    }

    return current;
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


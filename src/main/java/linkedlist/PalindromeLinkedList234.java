package linkedlist;

import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeLinkedList234 {
  ListNode current;
  int leftNode;
  int rightNode;
    
  public boolean isPalindrome(ListNode head) {
    Deque<Integer> deque = new ArrayDeque<>();
      
    if (head == null) {
      return false;
    }

    current = head;

    while (current != null) {
      deque.offer(current.val);
      current = current.next;
    }

    if (deque.size() == 1) {
      return true;
    }

    if (deque.size() % 2 != 0) {
      while (deque.size() > 1) {
        leftNode = deque.pollFirst();
        rightNode = deque.pollLast();
      
        if (leftNode != rightNode) {
          return false;
        }
      }
    }

    else {
      while (!deque.isEmpty()) {
        leftNode = deque.pollFirst();
        rightNode = deque.pollLast();

        if (leftNode != rightNode) {
          return false;
        }
      }
    }
      
    return true;
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


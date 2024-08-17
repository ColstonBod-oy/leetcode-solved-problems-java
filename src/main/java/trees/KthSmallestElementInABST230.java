package trees;

import java.util.Stack;

public class KthSmallestElementInABST230 {
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> s = new Stack<>();
    int n = 0;
    TreeNode curr = root;

    while (true) {
      while (curr != null) {
        s.push(curr);
        curr = curr.left;  
      }
      
      curr = s.pop();
      ++n;

      if (n == k) {
        return curr.val;
      }

      curr = curr.right;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public void printTree() {
      printTree("", this, false);
    }
    
    public void printTree(String prefix, TreeNode n, boolean isRight) {
      if (n != null) {
        System.out.println(prefix + (isRight ? "|-- " : "\\-- ") + n.val);
        printTree(prefix + (isRight ? "|   " : "    "), n.right, true);
        printTree(prefix + (isRight ? "|   " : "    "), n.left, false);
      }
    }
  }
}
import java.util.List;
import java.util.Deque;
import java.util.ArrayList;
import java.util.ArrayDeque;

class BinaryTreeRightSideView199 {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Deque<TreeNode> d = new ArrayDeque<>();
    d.offer(root);

    while (!d.isEmpty()) {
      int dLen = d.size();
      TreeNode curRight = null;

      while (dLen != 0) {
        TreeNode cur = d.poll();
        --dLen;
        
        if (cur != null) {
          curRight = cur;

          if (curRight.left != null) {
            d.offer(curRight.left);
          }
                    
          if (curRight.right != null) {
            d.offer(curRight.right);
          }
        }
      }

      if (curRight != null) {
        res.add(curRight.val);
      }
    }

    return res;
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
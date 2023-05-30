import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class BinaryTreeLevelOrderTraversal102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      List<Integer> subRes = new ArrayList<>();
      int qLen = q.size();
      
      while (qLen != 0) {
        TreeNode cur = q.poll();
        --qLen;

        if (cur != null) {
          subRes.add(cur.val);
          q.offer(cur.left);
          q.offer(cur.right);
        }
      }

      if (subRes.size() != 0) {
        res.add(subRes);
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
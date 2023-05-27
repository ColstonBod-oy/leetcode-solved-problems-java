class BinaryTreeMaximumPathSum124 {
  int res = Integer.MIN_VALUE;
  
  public int maxPathSum(TreeNode root) {
    dfsPathSum(root);
    return res;
  }

  private int dfsPathSum(TreeNode n) {
    if (n == null) return 0;
    
    int maxLeft = Math.max(dfsPathSum(n.left), 0);
    int maxRight = Math.max(dfsPathSum(n.right), 0);
    res = Math.max(res, n.val + maxLeft + maxRight);
    
    return n.val + Math.max(maxLeft, maxRight);
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
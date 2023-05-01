class BinaryTreeMaximumPathSum124 {
  public int maxPathSum(TreeNode root) {
    int[] res = {Integer.MIN_VALUE};
    maxPathSum(root, res);
    return res[0];
  }

  public int maxPathSum(TreeNode root, int[] res) {
    if (root == null) return 0;
    
    int maxLeft = Math.max(maxPathSum(root.left, res), 0);
    int maxRight = Math.max(maxPathSum(root.right, res), 0);
    res[0] = Math.max(res[0], root.val + maxLeft + maxRight);
    
    return root.val + Math.max(maxLeft, maxRight);
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
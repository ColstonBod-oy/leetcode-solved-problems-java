class DiameterOfBinaryTree543 {
  private int res = 0;
  
  public int diameterOfBinaryTree(TreeNode root) {
    getHeight(root);
    return res;
  }

  private int getHeight(TreeNode n) {
    if (n == null) {
      return -1;
    }
    
    int leftHeight = getHeight(n.left);
    int rightHeight = getHeight(n.right);
    res = Math.max(res, leftHeight + rightHeight + 2);

    return 1 + Math.max(leftHeight, rightHeight); 
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
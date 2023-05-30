class BalancedBinaryTree110 {
  boolean balanced = true;
  
  public boolean isBalanced(TreeNode root) {         
    getHeight(root);
    return balanced;
  }

  private int getHeight(TreeNode n) {
    if (n == null) {
      return -1;
    }

    int leftHeight = getHeight(n.left);
    int rightHeight = getHeight(n.right);

    if (Math.abs(leftHeight - rightHeight) > 1) {
      balanced = false;
    } 
   
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
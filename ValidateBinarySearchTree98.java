class ValidateBinarySearchTree98 {
  public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
  }

  private boolean validate(TreeNode n, Integer left, Integer right) {
    if (n == null) {
      return true;
    }

    if ((left != null && n.val <= left) || (right != null && n.val >= right)) {
      return false;
    }

    return validate(n.left, left, n.val) && validate(n.right, n.val, right);
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
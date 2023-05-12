class SubtreeOfAnotherTree572 {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (subRoot == null || isSameTree(root, subRoot)) return true;
    if (root == null) return false;

    return isSubtree(root.left, subRoot) || 
           isSubtree(root.right, subRoot);
  }

  private boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    
    if (p == null || q == null || 
        p.val != q.val) {
          return false;
    }

    return isSameTree(p.left, q.left) && 
           isSameTree(p.right, q.right);
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
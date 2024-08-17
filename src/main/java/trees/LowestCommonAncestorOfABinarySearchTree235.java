package trees;

public class LowestCommonAncestorOfABinarySearchTree235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (true) {
      if (p.val > root.val && q.val > root.val) {
        root = root.right;
      }

      else if (p.val < root.val && q.val < root.val) {
        root = root.left;
      }

      else {
        break;
      }
    }

    return root;
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
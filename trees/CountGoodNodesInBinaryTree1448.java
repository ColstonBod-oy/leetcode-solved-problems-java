package trees;

public class CountGoodNodesInBinaryTree1448 {
  public int goodNodes(TreeNode root) {
    return goodNodes(root, root.val);
  }

  public int goodNodes(TreeNode n, int maxVal) {
    if (n == null) {
      return 0;
    }

    int res = n.val >= maxVal ? 1 : 0;
    maxVal = Math.max(maxVal, n.val);
    res += goodNodes(n.left, maxVal);
    res += goodNodes(n.right, maxVal);

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
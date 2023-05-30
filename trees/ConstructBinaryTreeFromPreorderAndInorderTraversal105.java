package trees;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
  HashMap<Integer, Integer> map = new HashMap<>();
  
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0) {
      return null;
    }

    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    
    return buildTree(preorder, 0, 0, inorder.length - 1);
  }

  public TreeNode buildTree(int[] preorder, int preorderIndex, int inorderLow, int inorderHigh) {
    if (preorderIndex > preorder.length - 1 || 
        inorderLow > inorderHigh) {
          return null;
    }

    int mid = map.get(preorder[preorderIndex]);
    TreeNode n = new TreeNode(preorder[preorderIndex]);
    
    n.left = buildTree(
      preorder, 
      preorderIndex + 1, 
      inorderLow, 
      mid - 1
    );
    
    n.right = buildTree(
      preorder, 
      preorderIndex + mid - inorderLow + 1, 
      mid + 1, 
      inorderHigh
    );

    return n;
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
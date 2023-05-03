import java.util.StringJoiner;

class SerializeAndDeserializeBinaryTree297 {
  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringJoiner sj = new StringJoiner(",");
      serialize(root, sj);

      return sj.toString();
    }

    public void serialize(TreeNode n, StringJoiner sj) {
      if (n == null) {
        sj.add("n");
        return;
      }

      sj.add(Integer.toString(n.val));
      serialize(n.left, sj);
      serialize(n.right, sj);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String[] nodes = data.split(",");
      int[] counter = {0};

      if (nodes[counter[0]].equals("n")) {
        return null;
      }

      return deserialize(nodes[counter[0]], nodes, counter);
    }

    public TreeNode deserialize(String cur, String[] nodes, int[] counter) {
      if (cur.equals("n")) {
        ++counter[0];
        return null;
      }

      TreeNode n = new TreeNode(Integer.parseInt(cur));
      ++counter[0];
      n.left = deserialize(nodes[counter[0]], nodes, counter);
      n.right = deserialize(nodes[counter[0]], nodes, counter);

      return n;
    }
  }
  
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

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
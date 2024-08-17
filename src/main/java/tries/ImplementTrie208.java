package tries;

public class ImplementTrie208 {
  TrieNode root;
    
  public ImplementTrie208() {
    root = new TrieNode();
  }
    
  public void insert(String word) {
    TrieNode cur = root;
      
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode();
      }

      cur = cur.children[c - 'a'];
    }

    cur.isEndOfWord = true;
  }
    
  public boolean search(String word) {
    TrieNode cur = root;

    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        return false;
      }

      cur = cur.children[c - 'a'];
    }

    return cur.isEndOfWord;
  }
    
  public boolean startsWith(String prefix) {
    TrieNode cur = root;

    for (char c : prefix.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        return false;
      }

      cur = cur.children[c - 'a'];
    }

    return true;
  }
  

  class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    
    public TrieNode() {
      children = new TrieNode[26];
      isEndOfWord = false;
    }
  }
}
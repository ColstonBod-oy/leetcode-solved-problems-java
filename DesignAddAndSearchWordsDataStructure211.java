class DesignAddAndSearchWordsDataStructure211 {
  TrieNode root;
    
  public DesignAddAndSearchWordsDataStructure211() {
    root = new TrieNode();
  }
    
  public void addWord(String word) {
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
    return search(0, word, root);
  }

  public boolean search(int index, String word, TrieNode cur) {
    for (; index < word.length(); index++) {
      char c = word.charAt(index);

      if (c == '.') {
        for (TrieNode n : cur.children) {
          if (n != null && search(index + 1, word, n)) return true; 
        }

        return false;
      }

      else {
        if (cur.children[c - 'a'] == null) {
          return false;
        }

        cur = cur.children[c - 'a'];
      }
    }

    return cur.isEndOfWord;
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
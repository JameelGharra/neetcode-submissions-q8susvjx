class PrefixTree {
    TrieNode dummyHead;
    public PrefixTree() {
         dummyHead = new TrieNode();
    }

    public void insert(String word) {
        TrieNode reached = dummyHead;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (reached.children[index] == null) {
                reached.children[index] = new TrieNode();
            }
            reached = reached.children[index];
        }
        reached.isEndOfWord = true;
    }
    private TrieNode hasPath(String str) {
        int i = 0;
        TrieNode reached = dummyHead;
        while (i < str.length()) {
            TrieNode next = reached.children[str.charAt(i) - 'a'];
            if (next == null) {
                return null;
            }
            reached = next;
            ++i;
        }
        return reached;
    }
    public boolean search(String word) {
        TrieNode node = hasPath(word);
        return node != null && node.isEndOfWord; 
    }

    public boolean startsWith(String prefix) {
        return hasPath(prefix) != null;
    }

    private static class TrieNode {
        boolean isEndOfWord = false;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
        }
    }
}

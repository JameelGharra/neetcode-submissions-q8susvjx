class PrefixTree {
    TrieNode dummyHead;
    public PrefixTree() {
         dummyHead = new TrieNode();
    }

    public void insert(String word) {
        TrieNode reached = dummyHead;
        int i = 0;
        while (i < word.length()) {
            TrieNode next = reached.children[word.charAt(i) - 'a'];
            if (next == null)
                break;
            reached = next;
            ++i;
        }
        if (i == word.length()) {
            reached.isEndOfWord = true;
            return ;
        }
        while (i < word.length()) {
            TrieNode newNode = new TrieNode();
            reached.children[word.charAt(i) - 'a'] = newNode;
            reached = newNode;
            ++i;
        }
        reached.isEndOfWord = true;
    }
    private TrieNode hasPath(String str) {
        if (str.isEmpty())
            return null;
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

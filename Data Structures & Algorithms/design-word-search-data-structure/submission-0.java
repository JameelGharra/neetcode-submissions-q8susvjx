class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, TrieNode curr) {
        for (int i = idx; i < word.length(); ++i) {
            char c = word.charAt(i);
            int childIdx = c - 'a';
            if (c == '.') {
                for (int j = 0; j < 26; ++j) {
                    if (curr.children[j] != null) {
                        if (dfs(word, i + 1, curr.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            }
            else if (curr.children[childIdx] == null) {
                return false;
            }
            else {
                curr = curr.children[childIdx];
            }
        }
        return curr.isEndOfWord;
    }

    private static class TrieNode {
        boolean isEndOfWord = false;
        TrieNode[] children = new TrieNode[26];
    }
}

class Solution {
    private List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = prepareTrie(words);
        res = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                backtrack(board, i, j, root);
            }
        }
        return res;
    }

    private void backtrack(char[][] board, int i, int j, TrieNode curr) {
        if (curr.content != null) {
            res.add(curr.content);
            curr.content = null;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
        board[i][j] == '.') {
            return ;
        }
        int index = board[i][j] - 'a';
        if (curr.children[index] == null) {
            return ;
        }
        board[i][j] = '.';
        backtrack(board, i + 1, j, curr.children[index]);
        backtrack(board, i - 1, j, curr.children[index]);
        backtrack(board, i, j + 1, curr.children[index]);
        backtrack(board, i, j - 1, curr.children[index]);
        board[i][j] = (char)(index + 'a');
    }
    private TrieNode prepareTrie(String[] words) { 
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertToTrie(root, word);
        }
        return root;
    }
    private void insertToTrie(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (root.children[index] == null) {
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
        }
        root.content = word;
    }
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String content = null;
    }
}

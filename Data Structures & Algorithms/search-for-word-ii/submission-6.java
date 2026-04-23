class Solution {
    // read previous notes on solution 2, same as before just optimized a bit
    // more, but pruning I would argue it is slower in a way, but same time and space
    // pruning is cleaner and less bug-prone in a way although prev had no bugs
    // bye bye messy recursive returns 
    private List<String> res;
    private String[] words;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = prepareTrie(words);
        res = new ArrayList<>();
        this.words = words;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                backtrack(board, i, j, root);
            }
        }
        return res;
    }

    private void backtrack(char[][] board, int i, int j, TrieNode curr) {
        if (curr.idx != -1) {
            res.add(words[curr.idx]);
            curr.idx = -1;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
        board[i][j] == '.') {
            return ;
        }
        int index = board[i][j] - 'a';
        TrieNode nextNode = curr.children[index];
        if (nextNode == null) {
            return ;
        }
        board[i][j] = '.';

        backtrack(board, i + 1, j, nextNode);
        backtrack(board, i - 1, j, nextNode);
        backtrack(board, i, j + 1, nextNode);
        backtrack(board, i, j - 1, nextNode);
        
        board[i][j] = (char)(index + 'a');
        
        boolean isEmpty = true;
        for (TrieNode child : nextNode.children) {
            if (child != null) {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            curr.children[index] = null;
        }
    }
    private TrieNode prepareTrie(String[] words) { 
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; ++i) {
            insertToTrie(root, words[i], i);
        }
        return root;
    }
    private void insertToTrie(TrieNode root, String word, int idx) {
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (root.children[index] == null) {
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
        }
        root.idx = idx;
    }
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int idx = -1;
    }
}

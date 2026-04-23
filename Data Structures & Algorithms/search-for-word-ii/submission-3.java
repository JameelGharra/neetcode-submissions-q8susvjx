class Solution {
    // doing the preprocessing (generating the trie), 
    // we insert each word in the trie, if the longest word is of size n, 
    // and we do have m words, then the work is O(n * m), now to save 
    // all these words it is at most O(n * m) (worst-case when there is 
    // no overlapping between words). Now let's get to the backtracking part, 
    // we walk through every cell, and we do have a branching factor of 3 
    // (it is not 4, since we do not revisit a visited cell), so 
    // overall time complexity is O(a * b * 3^n) where a x b are dimensions 
    // of board. Auxiliary space: we have at most n recursive stack calls open, 
    // each with constant space, that's O(n), we used also O(n * m) space for trie, 
    // so it is O(n * m) auxiliary, and overall space complexity is O(n * m) for 
    // the output list as well.


    // O(a * b * 3^n) time - O(n * m) auxiliary and space complexity too
    // where a x b dimensions of board, n is longest word, m is number of words
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

    private int backtrack(char[][] board, int i, int j, TrieNode curr) {
        int wordExists = 0;
        if (curr.content != null) {
            res.add(curr.content);
            curr.content = null;
            wordExists++;
        }
        if (curr.wordsLeft == 0)
            return wordExists;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
        board[i][j] == '.') {
            return 0;
        }
        int index = board[i][j] - 'a';
        if (curr.children[index] == null) {
            return 0;
        }
        board[i][j] = '.';
        int a = backtrack(board, i + 1, j, curr.children[index]);
        int b = backtrack(board, i - 1, j, curr.children[index]);
        int c = backtrack(board, i, j + 1, curr.children[index]);
        int d = backtrack(board, i, j - 1, curr.children[index]);
        
        board[i][j] = (char)(index + 'a');
        curr.wordsLeft -= (a + b + c + d);
        return wordExists + a + b + c + d;
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
            ++root.wordsLeft;
            root = root.children[index];
        }
        root.content = word;
    }
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String content = null;
        int wordsLeft = 0;
    }
}

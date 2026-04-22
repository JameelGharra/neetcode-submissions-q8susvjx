class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean isFound = false;
            for (int i = 0; i < board.length && !isFound; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    if (backtrack(board, word, 0, i, j)) {
                        res.add(word);
                        isFound = true;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private boolean backtrack(char[][] board, String word, int wIndex, int i, int j) {
        if (wIndex == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || 
        j >= board[0].length || word.charAt(wIndex) != board[i][j]) {
            return false;
        }
        
        board[i][j] = '.';
        if (
            backtrack(board, word, wIndex + 1, i + 1, j) ||
            backtrack(board, word, wIndex + 1, i - 1, j) ||
            backtrack(board, word, wIndex + 1, i, j + 1) ||
            backtrack(board, word, wIndex + 1, i, j - 1)) {
            board[i][j] = word.charAt(wIndex);
            return true;
        }
        board[i][j] = word.charAt(wIndex);
        return false;
    }
}

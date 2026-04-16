class Solution {
    private static final char VISITED_CELL_VAL = '0';
    private static final int[][] directions = {
        {-1, 0}, // up
        {1, 0}, // down
        {0, 1}, // right
        {0, -1} // left
    };
    public boolean exist(char[][] board, String word) {
        if (word.length() < 1)
            return true;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0) && backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;  
    }
    private boolean backtrack(char[][] board, String word, int i, int j, int wIdx) {
        if (wIdx == word.length())  
            return true;

        if (word.charAt(wIdx) != board[i][j]) {
            return false;
        }
        else if (wIdx == word.length() - 1) {
            return true;
        }
        board[i][j] = VISITED_CELL_VAL;
        for (int[] direction : directions) {
            int newRowIdx = i + direction[0], newColIdx = j + direction[1];
            if (!isValidIndex(board, newRowIdx, newColIdx) || 
                board[newRowIdx][newColIdx] == VISITED_CELL_VAL) {
                continue;
            }
            if (backtrack(board, word, newRowIdx, newColIdx, wIdx + 1)) {
                board[i][j] = word.charAt(wIdx); // added that incase board has to remain unchanged
                return true;
            }
        }
        board[i][j] = word.charAt(wIdx);
        return false;
    }
    private static boolean isValidIndex(char[][] arr, int i, int j) {
        return i >= 0 && i < arr.length && j >= 0 && j < arr[0].length;
    }
}

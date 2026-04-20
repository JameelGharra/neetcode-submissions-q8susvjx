class Solution {
    // for fun literally the same just boolean array instead (supposed to 
    // be faster)

    private List<List<String>> res;
    private boolean[] cols;
    private boolean[] negDiag;
    private boolean[] posDiag;
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        res = new ArrayList<>();
        cols = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        board = new char[n][n];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] = '.';
            }
        }
        backtrack(0, n);
        return res;
    }

    private void backtrack(int row, int n) {
        if (row == board.length) {
            List<String> boardState = new ArrayList<>();
            for (char[] boardRow : board) {
                boardState.add(new String(boardRow));
            }
            res.add(boardState);
            return ;
        }
        for (int col = 0; col < board[0].length; ++col) {
            if (!cols[col] && !posDiag[row + col] &&
            !negDiag[row - col + n]) {
                board[row][col] = 'Q';
                cols[col] = true;
                posDiag[row + col] = true;
                negDiag[row - col + n] = true;
                backtrack(row + 1, n);
                board[row][col] = '.';
                cols[col] = false;
                posDiag[row + col] = false;
                negDiag[row - col + n] = false;
            }
        }
    }
}

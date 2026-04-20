class Solution {
    // for fun literally the same just boolean array instead (supposed to 
    // be faster)

    private List<List<String>> res;
    private boolean[] cols;
    private boolean[] negDiag;
    private boolean[] posDiag;
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        cols = new boolean[n];
        // we are actually here using 2n - 1 elements for each not 2n :-)
        // 0 is counted twice and look at maximum and minimum
        // we can use posDiag of size 2n - 1 if we want to instead of n
        // we can use same for negDiag with size 2n - 1, but we would add n - 1
        // and not n (shifting) so we force it to use index 0 as min not 1
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        backtrack(0, n);
        return res;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            List<String> boardState = new ArrayList<>();
            for (char[] boardRow : board) {
                boardState.add(new String(boardRow));
            }
            res.add(boardState);
            return ;
        }
        for (int col = 0; col < n; ++col) {
            if (!cols[col] && !posDiag[row + col] &&
            !negDiag[row - col + n]) {
                board[row][col] = 'Q';
                cols[col] = true;
                posDiag[row + col] = true;
                // the + n to prevent negative indexing
                // notice that we are not using negDiag[0] :D
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

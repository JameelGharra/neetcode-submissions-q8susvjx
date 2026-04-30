class Solution {
    // reverse dfs strategy

    private static final int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        for (int i = 0; i < ROWS; ++i) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][COLS - 1] == 'O') {
                dfs(board, i, COLS - 1);
            }
        }
        for (int j = 0; j < COLS; ++j) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[ROWS - 1][j] == 'O')
                dfs(board, ROWS - 1, j);
        }
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        board[r][c] = '#';
        for (int[] dir : dirs) {
            int newR = r + dir[0], newC = c + dir[1];
            if (newR < 0 || newC < 0 || newR == board.length || 
                newC == board[0].length ||
                board[newR][newC] != 'O') {
                continue;
            }
            dfs(board, newR, newC);
        }
    }
}

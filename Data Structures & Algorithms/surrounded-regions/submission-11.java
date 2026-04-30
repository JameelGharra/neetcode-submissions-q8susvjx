class Solution {
    public void solve(char[][] board) {
        Set<int[]> group;
        for (int i = 1; i < board.length - 1; ++i) {
            for (int j = 1; j < board[0].length - 1; ++j) {
                if (board[i][j] == 'O') {
                    group = new HashSet<>();
                    if (!dfs(board, i, j, group)) {
                        for (int[] pair : group) {
                            board[pair[0]][pair[1]] = 'F';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '#')
                    board[i][j] = 'X';
                if (board[i][j] == 'F')
                    board[i][j] = 'O';
            }
        }
    }
    private static final int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    private boolean dfs(char[][]board, int r, int c, Set<int[]> group) {
        if (r < 0 || c < 0 || r == board.length || 
            c == board[0].length || board[r][c] == 'F') {
            return false;
        }
        if (board[r][c] == 'X' || board[r][c] == '#')
            return true;

        group.add(new int[]{r, c});
        board[r][c] = '#';
        boolean testGroup = true;
        for (int[] dir : dirs) {
            int newR = r + dir[0], newC = c + dir[1];
            testGroup = testGroup & dfs(board, newR, newC, group);
        }
        return testGroup;
    }
}

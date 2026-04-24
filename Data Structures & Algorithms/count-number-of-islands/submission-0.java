class Solution {
    private int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++res;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
        grid[r][c] == '.' || grid[r][c] == '0') {
            return ;
        }
        grid[r][c] = '.';
        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(grid, newR, newC);
        }
    }
}

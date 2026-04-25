class Solution {
    private int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
            grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 0;
        int total = 0;
        for (int[] dir : dirs) {
            total += dfs(grid, r + dir[0], c + dir[1]);
        }
        return 1 + total;
    }
}

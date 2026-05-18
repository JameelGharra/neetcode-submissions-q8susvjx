class Solution {
    private int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int swimInWater(int[][] grid) {
        int minH = grid[0][0], maxH = grid[0][0], n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                minH = Math.min(minH, grid[i][j]);
                maxH = Math.max(maxH, grid[i][j]);
            }
        }
        boolean[][] visited = new boolean[n][n];
        for (int maxElevation = minH; maxElevation < maxH; ++maxElevation) {
            if (dfs(grid, 0, 0, visited, maxElevation))
                return maxElevation;
            for (int i = 0; i < n; ++i) {
                Arrays.fill(visited[i], false);
            }
        }
        return maxH;
    }
    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited, int elevation) {
        if (grid[i][j] > elevation) {
            return false;
        }
        if (i == grid.length - 1 && j == grid.length - 1)
            return true;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int newR = i + dir[0], newC = j + dir[1];
            if (newR < 0 || newC < 0 || newR >= grid.length ||
                newC >= grid.length || visited[newR][newC])
                continue;
            if (dfs(grid, newR, newC, visited, elevation))
                return true;
        }
        return false;
    }
}

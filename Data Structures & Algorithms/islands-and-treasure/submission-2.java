class Solution {
    private static final int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    bfs(grid, i, j);
                }
            }
        }
    }

    private void bfs(int[][] grid, int i, int j) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int pair[] = queue.poll(), r = pair[0], c = pair[1];
            for (int[] dir : dirs) {
                int newR = r + dir[0], newC = c + dir[1];
                if (newR < 0 || newC < 0 || newR >= grid.length ||
                    newC >= grid[0].length || grid[newR][newC] == -1 ||
                    visited[newR][newC]) {
                    continue;
                }
                visited[newR][newC] = true;
                queue.add(new int[]{newR, newC});
                grid[newR][newC] = Math.min(grid[newR][newC], 1 + grid[r][c]);
            }
        }
    }
}

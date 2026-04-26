class Solution {
    // BFS
    private static final int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }
    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        grid[r][c] = 0;
        int area = 1;
        while (!queue.isEmpty()) {
            int pair[] = queue.poll(), i = pair[0], j = pair[1];
            for (int[] dir : dirs) {
                int newR = i + dir[0], newC = j + dir[1];
                if (newR < 0 || newC < 0 || newR >= grid.length ||
                    newC >= grid[0].length || grid[newR][newC] != 1) {
                    continue;
                }
                grid[newR][newC] = 0;
                queue.add(new int[]{newR, newC});
                ++area;
            }
        }
        return area;
    }
}

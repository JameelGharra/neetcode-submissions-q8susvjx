class Solution {
    // straight to business multi-source bfs
    private static final int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});            
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            for (int[] dir : dirs) {
                int newR = pair[0] + dir[0], newC = pair[1] + dir[1];
                if (newR < 0 || newC < 0 || newR >= grid.length ||
                    newC >= grid[0].length || grid[newR][newC] != Integer.MAX_VALUE ||
                    grid[newR][newC] == -1) {
                        continue;
                }
                grid[newR][newC] = grid[pair[0]][pair[1]] + 1;
                queue.add(new int[]{newR, newC});
            }
        }
    }
}
